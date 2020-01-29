package go.univer.dao.impl;

import go.univer.dao.DBConnector;
import go.univer.dao.UserDao;
import go.univer.domain.users.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CrudPaginalDaoImpl implements UserDao {

	protected final DBConnector connector;

	private static final String FIND_BY_EMAIL_QUERY = "SELECT * FROM users WHERE email=?";
	private static final String FIND_BY_ID_QUERY = "SELECT * FROM users WHERE id=?";
	private static final String FIND_ALL_QUERY = "SELECT * FROM users";

	public CrudPaginalDaoImpl(DBConnector connector) {
		this.connector = connector;
	}

	@Override
	public Optional<User> findById(Integer id) {
		try (final PreparedStatement preparedStatement =
					 connector.getConnection().prepareStatement(FIND_BY_ID_QUERY)) {
			preparedStatement.setInt(1, id);

			try (final ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					return Optional.of(mapResultSetToEntity(resultSet));
				}
			}

		} catch (SQLException e) {
			//log
			e.printStackTrace();	// TODO log, custom exception
		}

		return Optional.empty();
	}

	@Override
	public Optional<User> findByEmail(String email) {
		try (final PreparedStatement preparedStatement =
					 connector.getConnection().prepareStatement(FIND_BY_EMAIL_QUERY)) {
			preparedStatement.setString(1, email);

			try (final ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					return Optional.of(mapResultSetToEntity(resultSet));
				}
			}

		} catch (SQLException e) {
			//log
			e.printStackTrace();
		}

		return Optional.empty();
	}

	@Override
	public void save(User entity) {

	}

	@Override
	public List<User> findAll(int page, int itemPerPage) {
		try (final PreparedStatement preparedStatement =
					 connector.getConnection().prepareStatement(FIND_ALL_QUERY)) {
			try (final ResultSet resultSet = preparedStatement.executeQuery()) {
				List<User> users = new ArrayList<>();
				while (resultSet.next()) {
					final User optionalUser = mapResultSetToEntity(resultSet);
					users.add(optionalUser);
				}
				return users;
			}

		} catch (SQLException e) {
			//log
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	@Override
	public long count() {
		return 0;
	}

	protected User mapResultSetToEntity(ResultSet resultSet) throws SQLException {
		return User.builder()
				.withId(resultSet.getInt("id"))
				.withEmail(resultSet.getString("email"))
				.withPassword(resultSet.getString("password"))
				.withFirstName(resultSet.getString("first_name"))
				.withLastName(resultSet.getString("last_name"))
				.withRole(User.Role.values()[resultSet.getInt("isadmin")])
				.build();
	}

	@Override
	public void update(User entity) {

	}

	@Override
	public void deleteById(Integer id) {

	}
}
