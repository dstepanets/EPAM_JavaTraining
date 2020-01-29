package go.univer.dao.impl;

import go.univer.dao.DBConnector;
import go.univer.dao.UserDao;
import go.univer.entity.users.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static go.univer.util.StaticTools.LOGGER;

public class UserDaoImpl extends AbstractCrudDaoImpl<User> implements UserDao {

	private static final String FIND_BY_EMAIL_QUERY = "SELECT * FROM users WHERE email=?";
	private static final String FIND_BY_ID_QUERY = "SELECT * FROM users WHERE id=?";
	private static final String FIND_ALL_QUERY = "SELECT * FROM users";
	private static final String SAVE_USER_QUERY =
			"INSERT INTO users (email, password, first_name, last_name, isadmin) " +
								"VALUES ('?', '?', '?', '?', ?);";
	private static final String UPDATE_USER_QUERY =
			"UPDATE users SET email='?', password='?', first_name='?', last_name='?', isadmin=? " +
			"WHERE id=?";
	private static final String DELETE_BY_ID_QUERY = "DELETE FROM users WHERE id=?;";

	public UserDaoImpl(DBConnector connector) {
		super(connector, FIND_BY_ID_QUERY);
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
			LOGGER.error(e.getStackTrace());
		}
		return Optional.empty();
	}

	@Override
	public void save(User user) {
		try (final PreparedStatement preparedStatement =
					 connector.getConnection().prepareStatement(SAVE_USER_QUERY)) {
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getFirstName());
			preparedStatement.setString(4, user.getLastName());
			preparedStatement.setInt(5, user.getRole().ordinal());
			try (final ResultSet resultSet = preparedStatement.executeQuery()) {
//				TODO log insertion
			}
		} catch (SQLException e) {
			LOGGER.error(e.getStackTrace());
		}
	}

//	TODO Pagination
	@Override
	public List<User> findAll() {
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
			LOGGER.error(e.getStackTrace());
		}
		return Collections.emptyList();
	}

	@Override
	public long count() {
		return 0;		//	TODO impl count
	}


	@Override
	public void update(User user) {
		try (final PreparedStatement preparedStatement =
					 connector.getConnection().prepareStatement(UPDATE_USER_QUERY)) {
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getFirstName());
			preparedStatement.setString(4, user.getLastName());
			preparedStatement.setInt(5, user.getRole().ordinal());
			preparedStatement.setInt(6, user.getId());
			try (final ResultSet resultSet = preparedStatement.executeQuery()) {
//				TODO log insertion
			}
		} catch (SQLException e) {
			LOGGER.error(e.getStackTrace());
		}
	}

	@Override
	public void deleteById(Integer id) {
		try (final PreparedStatement preparedStatement =
					 connector.getConnection().prepareStatement(DELETE_BY_ID_QUERY)) {
			preparedStatement.setString(1, id);
			try (final ResultSet resultSet = preparedStatement.executeQuery()) {
//				TODO log insertion
			}
		} catch (SQLException e) {
			LOGGER.error(e.getStackTrace());
		}
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

}
