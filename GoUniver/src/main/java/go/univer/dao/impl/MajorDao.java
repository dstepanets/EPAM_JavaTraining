package go.univer.dao.impl;

import go.univer.dao.DBConnector;
import go.univer.entity.Major;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MajorDao extends AbstractCrudDao<Major> {
	private static final Logger LOGGER = LogManager.getLogger(MajorDao.class);

	private static final String FIND_ALL_QUERY = "SELECT * FROM majors";
	private static final String SAVE_MAJOR_QUERY = "INSERT INTO majors (title) VALUES ('?');";
	private static final String UPDATE_MAJOR_QUERY = "UPDATE majors SET title='?' WHERE id=?";

	public MajorDao() {
		super("majors");
	}

	@Override
	public List<Major> findAll() {
		try (final Connection conn = DBConnector.getConnection();
			 final PreparedStatement statement = conn.prepareStatement(FIND_ALL_QUERY)) {
			try (final ResultSet resultSet = statement.executeQuery()) {
				List<Major> majors = new ArrayList<>();
				while (resultSet.next()) {
					final Major major = mapResultSetToEntity(resultSet);
					majors.add(major);
				}
				return majors;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return Collections.emptyList();
	}


	@Override
	public void save(Major major) {
		try (final Connection conn = DBConnector.getConnection();
			 final PreparedStatement statement = conn.prepareStatement(SAVE_MAJOR_QUERY)) {
			statement.setString(1, major.getTitle());
			try (final ResultSet resultSet = statement.executeQuery()) {
				LOGGER.debug(String.format("Saving new major: %s", major));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void update(Major major) {
		try (final Connection conn = DBConnector.getConnection();
			 final PreparedStatement statement = conn.prepareStatement(UPDATE_MAJOR_QUERY)) {
			statement.setInt(1, major.getId());
			statement.setString(2, major.getTitle());
			try (final ResultSet resultSet = statement.executeQuery()) {
				LOGGER.debug(String.format("Executing major update query: ['%s']", statement));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	protected Major mapResultSetToEntity(ResultSet resultSet) throws SQLException {
		final int id = resultSet.getInt(1);
		final String title = resultSet.getString("title");
		return new Major(id, title, Collections.EMPTY_LIST, 0);
	}
}
