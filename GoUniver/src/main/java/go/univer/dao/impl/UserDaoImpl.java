package go.univer.dao.impl;

import go.univer.dao.DBConnector;
import go.univer.dao.Page;
import go.univer.dao.PaginalList;
import go.univer.dao.UserDao;
import go.univer.entity.users.UserEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractCrudDao<UserEntity> implements UserDao {
	private static final Logger LOGGER = LogManager.getLogger(UserDaoImpl.class);

	private static final String FIND_BY_EMAIL_QUERY = "SELECT * FROM users WHERE email=?;";
	private static final String FIND_ALL_QUERY = "SELECT * FROM users";
	private static final String FIND_ALL_PAGINAL_QUERY = "SELECT * FROM users LIMIT ?, ?;";
	private static final String SAVE_USER_QUERY =
			"INSERT INTO users (email, password, salt, first_name, last_name, isadmin) " +
					"VALUES (?, ?, ?, ?, ?, ?);";
	private static final String UPDATE_USER_QUERY =
			"UPDATE users SET email='?', password='?', salt='?' first_name='?', last_name='?', isadmin=? " +
					"WHERE id=?;";


	public UserDaoImpl() {
		super("users");
	}

	@Override
	public Optional<UserEntity> findByEmail(String email) {
		return findByParam(email, FIND_BY_EMAIL_QUERY, STRING_PARAM_SETTER);
	}

	@Override
	public void save(UserEntity userEntity) {
		try (final PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(SAVE_USER_QUERY)) {
			preparedStatement.setString(1, userEntity.getEmail());
			preparedStatement.setString(2, userEntity.getPassword());
			preparedStatement.setString(3, userEntity.getSalt());
			preparedStatement.setString(4, userEntity.getFirstName());
			preparedStatement.setString(5, userEntity.getLastName());
			preparedStatement.setInt(6, userEntity.getRole().ordinal());
			try (final ResultSet resultSet = preparedStatement.executeQuery()) {
				LOGGER.debug(String.format("Saving new user: %s", userEntity));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public List<UserEntity> findAll() {
		try (final PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(FIND_ALL_QUERY)) {
			try (final ResultSet resultSet = preparedStatement.executeQuery()) {
				List<UserEntity> userEntities = new ArrayList<>();
				while (resultSet.next()) {
					final UserEntity userEntity = mapResultSetToEntity(resultSet);
					userEntities.add(userEntity);
				}
				return userEntities;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return Collections.emptyList();
	}

	@Override
	public PaginalList<UserEntity> findAll(Page page) {
		List<UserEntity> userEntities = new ArrayList<>();
		int maxPageNum = (count() / page.getItemsPerPage() + 1);
		try (final PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(FIND_ALL_PAGINAL_QUERY)) {
			preparedStatement.setInt(1, (page.getPageNum() - 1) * page.getItemsPerPage());
			preparedStatement.setInt(2, page.getItemsPerPage());
			try (final ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					final UserEntity userEntity = mapResultSetToEntity(resultSet);
					userEntities.add(userEntity);
				}
				return new PaginalList<>(userEntities, page, maxPageNum);
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return new PaginalList<>(userEntities, page, maxPageNum);
	}

	@Override
	public void update(UserEntity userEntity) {
		try (final PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(UPDATE_USER_QUERY)) {
			preparedStatement.setString(1, userEntity.getEmail());
			preparedStatement.setString(2, userEntity.getPassword());
			preparedStatement.setString(3, userEntity.getSalt());
			preparedStatement.setString(4, userEntity.getFirstName());
			preparedStatement.setString(5, userEntity.getLastName());
			preparedStatement.setInt(6, userEntity.getRole().ordinal());
			preparedStatement.setInt(7, userEntity.getId());
			try (final ResultSet resultSet = preparedStatement.executeQuery()) {
				LOGGER.debug(String.format("Executing user update query: ['%s']", preparedStatement));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	protected UserEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
		return UserEntity.builder()
				.withId(resultSet.getInt("id"))
				.withEmail(resultSet.getString("email"))
				.withPassword(resultSet.getString("password"))
				.withSalt(resultSet.getString("salt"))
				.withFirstName(resultSet.getString("first_name"))
				.withLastName(resultSet.getString("last_name"))
				.withRole(UserEntity.Role.values()[resultSet.getInt("isadmin")])
				.build();
	}


	//	TODO tmp
	public void populateDefaultPasswords(String encryptedPass) {
		final String sql = "UPDATE users SET password=?;";
		try (final PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement(sql)) {
			preparedStatement.setString(1, encryptedPass);
			preparedStatement.executeUpdate();
			LOGGER.debug(String.format("Executing user update query: ['%s']", preparedStatement));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}


}
