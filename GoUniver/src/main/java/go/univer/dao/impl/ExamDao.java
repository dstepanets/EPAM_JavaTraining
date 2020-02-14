package go.univer.dao.impl;

import go.univer.dao.DBConnector;
import go.univer.entity.Exam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExamDao extends AbstractCrudDao<Exam> {
	private static final Logger LOGGER = LogManager.getLogger(ExamDao.class);

	private static final String FIND_ALL_QUERY = "SELECT * FROM exams";
	private static final String SAVE_EXAM_QUERY = "INSERT INTO exams (subject) VALUES ('?');";
	private static final String UPDATE_EXAM_QUERY = "UPDATE exams SET subject='?' WHERE id=?";

	public ExamDao() {
		super("exams");
	}

	@Override
	public List<Exam> findAll() {
		try (final Connection conn = DBConnector.getConnection();
			 final PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY)) {
			try (final ResultSet resultSet = statement.executeQuery()) {
				List<Exam> exams = new ArrayList<>();
				while (resultSet.next()) {
					final Exam exam = mapResultSetToEntity(resultSet);
					exams.add(exam);
				}
				return exams;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return Collections.emptyList();
	}

	@Override
	public void save(Exam exam) {
		try (final Connection conn = DBConnector.getConnection();
			 final PreparedStatement statement = conn.prepareStatement(SAVE_EXAM_QUERY)) {
			statement.setString(1, exam.getSubject());
			try (final ResultSet resultSet = statement.executeQuery()) {
				LOGGER.debug(String.format("Saving new exam: %s", exam));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void update(Exam exam) {
		try (final Connection conn = DBConnector.getConnection();
			 final PreparedStatement statement = conn.prepareStatement(UPDATE_EXAM_QUERY)) {
			statement.setInt(1, exam.getId());
			statement.setString(2, exam.getSubject());
			try (final ResultSet resultSet = statement.executeQuery()) {
				LOGGER.debug(String.format("Executing exams update query: ['%s']", statement));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	protected Exam mapResultSetToEntity(ResultSet resultSet) throws SQLException {
		final int id = resultSet.getInt(1);
		final String subject = resultSet.getString("subject");
		return new Exam(id, subject, 0);
	}
}
