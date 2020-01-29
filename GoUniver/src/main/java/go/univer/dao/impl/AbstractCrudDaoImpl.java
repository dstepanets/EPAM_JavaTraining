package go.univer.dao.impl;

import go.univer.dao.CrudDao;
import go.univer.dao.DBConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.function.BiConsumer;

import static go.univer.util.StaticTools.LOGGER;

public abstract class AbstractCrudDaoImpl<E> implements CrudDao<E> {

	private static final BiConsumer<PreparedStatement, Integer> INT_PARAM_SETTER = (preparedStatement, integer) -> {
		try {
			preparedStatement.setInt(1, integer);
			// preparedStatement.setObject();
		} catch (SQLException e) {
			LOGGER.error(e.getStackTrace());
		}
	};

	protected static final BiConsumer<PreparedStatement, String> STRING_PARAM_SETTER = (preparedStatement, str) -> {
		try {
			preparedStatement.setString(1, str);
		} catch (SQLException e) {
			LOGGER.error(e.getStackTrace());
		}
	};

	protected final DBConnector connector;
	private final String findByIdQuery;


	protected AbstractCrudDaoImpl(DBConnector connector, String findByIdQuery) {
		this.connector = connector;
		this.findByIdQuery = findByIdQuery;
	}

	@Override
	public void save(E entity) {
		//	TODO generic impl
	}

	@Override
	public Optional<E> findById(Integer id) {
		return findByParam(id, findByIdQuery, INT_PARAM_SETTER);
	}

	protected <P> Optional<E> findByParam(P param, String findByParam, BiConsumer<PreparedStatement, P> designatedParamSetter) {
		try (final PreparedStatement preparedStatement =
					 connector.getConnection().prepareStatement(findByParam)) {
			designatedParamSetter.accept(preparedStatement, param);
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
	public void update(E entity) {

	}

	@Override
	public void deleteById(Integer id) {

	}

	protected abstract E mapResultSetToEntity(ResultSet resultSet) throws SQLException;
}
