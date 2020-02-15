package go.univer.dao.impl;

import go.univer.dao.DBConnector;
import go.univer.dao.Page;
import go.univer.dao.PaginalList;
import go.univer.dao.UserDao;
import go.univer.entity.users.UserEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
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
		try (final Connection conn = DBConnector.getConnection();
			 final PreparedStatement statement = conn.prepareStatement(SAVE_USER_QUERY)) {
			statement.setString(1, userEntity.getEmail());
			statement.setString(2, userEntity.getPassword());
			statement.setString(3, userEntity.getSalt());
			statement.setString(4, userEntity.getFirstName());
			statement.setString(5, userEntity.getLastName());
			statement.setInt(6, userEntity.getRole().ordinal());
			int ret = statement.executeUpdate();
			LOGGER.debug(String.format("New user saved: %s", userEntity));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public PaginalList<UserEntity> findAll(Page page) {
		List<UserEntity> userEntities = new ArrayList<>();
		int maxPageNum = (count() / page.getItemsPerPage() + 1);
		try (final Connection conn = DBConnector.getConnection();
			 final PreparedStatement statement = conn.prepareStatement(FIND_ALL_PAGINAL_QUERY)) {
			statement.setInt(1, (page.getPageNum() - 1) * page.getItemsPerPage());
			statement.setInt(2, page.getItemsPerPage());
			try (final ResultSet resultSet = statement.executeQuery()) {
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
		try (final Connection conn = DBConnector.getConnection();
			 final PreparedStatement statement = conn.prepareStatement(UPDATE_USER_QUERY)) {
			statement.setString(1, userEntity.getEmail());
			statement.setString(2, userEntity.getPassword());
			statement.setString(3, userEntity.getSalt());
			statement.setString(4, userEntity.getFirstName());
			statement.setString(5, userEntity.getLastName());
			statement.setInt(6, userEntity.getRole().ordinal());
			statement.setInt(7, userEntity.getId());
			int ret = statement.executeUpdate();
			LOGGER.debug(String.format("User update query executed: ['%s'] Rows changed: %d", statement, ret));
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
/*	public void populateDefaultPasswords(String encryptedPass) {
		final String sql = "UPDATE users SET password=?;";
		try (final Connection conn = DBConnector.getConnection();
			 final PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, encryptedPass);
			statement.executeUpdate();
			LOGGER.debug(String.format("Executing user update query: ['%s']", statement));
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}*/


}
