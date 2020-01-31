package go.univer.dao.impl;

import go.univer.dao.DBConnector;
import go.univer.dao.Page;
import go.univer.dao.PaginalList;
import go.univer.dao.UserDao;
import go.univer.entity.users.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractCrudDao<User> implements UserDao {
	private static final Logger LOGGER = LogManager.getLogger(UserDaoImpl.class);

	private static final String FIND_BY_EMAIL_QUERY = "SELECT * FROM users WHERE email=?";
	private static final String FIND_ALL_QUERY = "SELECT * FROM users";
	private static final String FIND_ALL_PAGINAL_QUERY = "SELECT * FROM users LIMIT ?, ?";
	private static final String SAVE_USER_QUERY =
			"INSERT INTO users (email, password, first_name, last_name, isadmin) " +
			"VALUES ('?', '?', '?', '?', ?);";
	private static final String UPDATE_USER_QUERY =
			"UPDATE users SET email='?', password='?', first_name='?', last_name='?', isadmin=? " +
			"WHERE id=?";


	public UserDaoImpl() {
		super("users");
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return findByParam(email, FIND_BY_EMAIL_QUERY, STRING_PARAM_SETTER);
	}

	@Override
	public void save(User user) {
		try (final PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(SAVE_USER_QUERY)) {
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getFirstName());
			preparedStatement.setString(4, user.getLastName());
			preparedStatement.setInt(5, user.getRole().ordinal());
			try (final ResultSet resultSet = preparedStatement.executeQuery()) {
				LOGGER.debug(String.format("Saving new user: %s", user));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public List<User> findAll() {
		try (final PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(FIND_ALL_QUERY)) {
			try (final ResultSet resultSet = preparedStatement.executeQuery()) {
				List<User> users = new ArrayList<>();
				while (resultSet.next()) {
					final User user = mapResultSetToEntity(resultSet);
					users.add(user);
				}
				return users;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return Collections.emptyList();
	}

	@Override
	public PaginalList<User> findAll(Page page) {
		List<User> users = new ArrayList<>();
		int maxPageNum = (int) (count() / page.getItemsPerPage() + 1);
		try (final PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(FIND_ALL_PAGINAL_QUERY)) {
			preparedStatement.setInt(1, (page.getPageNum() - 1) * page.getItemsPerPage());
			preparedStatement.setInt(1, page.getItemsPerPage());
			try (final ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					final User user = mapResultSetToEntity(resultSet);
					users.add(user);
				}
				return new PaginalList<>(users, page, maxPageNum);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return new PaginalList<>(users, page, maxPageNum);
	}

	@Override
	public void update(User user) {
		try (final PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(UPDATE_USER_QUERY)) {
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getFirstName());
			preparedStatement.setString(4, user.getLastName());
			preparedStatement.setInt(5, user.getRole().ordinal());
			preparedStatement.setInt(6, user.getId());
			try (final ResultSet resultSet = preparedStatement.executeQuery()) {
				LOGGER.debug(String.format("Executing user update query: ['%s']", preparedStatement));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
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
