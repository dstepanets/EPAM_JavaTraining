package go.univer.dao.impl;

import go.univer.dao.CrudDao;
import go.univer.dao.DBConnector;
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
import java.util.function.BiConsumer;


public abstract class AbstractCrudDao<E> implements CrudDao<E> {
	private static final Logger LOGGER = LogManager.getLogger(AbstractCrudDao.class);

	private static final BiConsumer<PreparedStatement, Integer> INT_PARAM_SETTER = (preparedStatement, integer) -> {
		try {
			preparedStatement.setInt(1, integer);
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	};

	protected static final BiConsumer<PreparedStatement, String> STRING_PARAM_SETTER = (preparedStatement, str) -> {
		try {
			preparedStatement.setString(1, str);
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	};

	private final String findByIdQuery;
	private final String countRowsQuery;
	private final String deleteByIdQuery;
	private final String findAllQuery;

	protected AbstractCrudDao(String tableName) {
		findByIdQuery = String.format("SELECT * FROM %s WHERE id=?", tableName);
		countRowsQuery = String.format("SELECT COUNT(*) FROM %s;", tableName);
		deleteByIdQuery = String.format("DELETE FROM %s WHERE id=?;", tableName);
		findAllQuery = String.format("SELECT * FROM %s", tableName);
	}

	@Override
	public Optional<E> findById(Integer id) {
		return findByParam(id, findByIdQuery, INT_PARAM_SETTER);
	}

	protected <P> Optional<E> findByParam(P param, String findByParamQuery, BiConsumer<PreparedStatement, P> paramSetter) {
		try (final Connection conn = DBConnector.getConnection();
			 final PreparedStatement statement = conn.prepareStatement(findByParamQuery)) {
			paramSetter.accept(statement, param);
			try (final ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return Optional.of(mapResultSetToEntity(resultSet));
				}
			}
		} catch (SQLException e) {
			LOGGER.error(String.format("[Failed query: '%s'] %s", findByParamQuery, e));
		}
		return Optional.empty();
	}

	@Override
	public void deleteById(Integer id) {
		try (final Connection conn = DBConnector.getConnection();
			 final PreparedStatement statement = conn.prepareStatement(deleteByIdQuery)) {
			statement.setInt(1, id);
			int ret = statement.executeUpdate();
			LOGGER.debug(String.format("Removing DB entry. Query: ['%s'] Rows changed: %d", statement, ret));
		} catch (SQLException e) {
			LOGGER.error(String.format("[Failed query: '%s' id=%d] %s", deleteByIdQuery, id, e));
		}
	}

	@Override
	public int count() {
		try (final Connection conn = DBConnector.getConnection();
			 final PreparedStatement statement = conn.prepareStatement(countRowsQuery)) {
			try (final ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return resultSet.getInt(1);
				}
			}
		} catch (SQLException e) {
			LOGGER.error(String.format("[Failed query: '%s'] %s", countRowsQuery, e));
		}
		return 0;
	}

	public List<E> findAll() {
		try (final Connection conn = DBConnector.getConnection();
			 final PreparedStatement statement = conn.prepareStatement(findAllQuery)) {
			try (final ResultSet resultSet = statement.executeQuery()) {
				List<E> entities = new ArrayList<>();
				while (resultSet.next()) {
					final E entity = mapResultSetToEntity(resultSet);
					entities.add(entity);
				}
				return entities;
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return Collections.emptyList();
	}

	protected abstract E mapResultSetToEntity(ResultSet resultSet) throws SQLException;

}
