package go.univer.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnector {
	private static final Logger LOGGER = LogManager.getLogger(DBConnector.class);

	private static final String DEFAULT_POPERTIES_FILE_PATH = "db/database";
	private static final HikariConfig CONFIG = new HikariConfig();
	private static HikariDataSource dataSource;

	public static Connection getConnection() throws SQLException {
		setConfigs(DEFAULT_POPERTIES_FILE_PATH);
		return dataSource.getConnection();
	}

	public static Connection getConnection(String propertiesFilePath) throws SQLException {
		setConfigs(propertiesFilePath);
		return dataSource.getConnection();
	}

	private static void setConfigs(String propertiesFilePath) {
		ResourceBundle resource = ResourceBundle.getBundle(propertiesFilePath);
		CONFIG.setJdbcUrl(resource.getString("jdbcUrl"));
		CONFIG.setUsername(resource.getString("username"));
		CONFIG.setPassword(resource.getString("password"));
		CONFIG.setDriverClassName(resource.getString("driverClassName"));
		CONFIG.addDataSourceProperty("cachePrepStmts", resource.getString("DS.cachePrepStmts"));
		CONFIG.addDataSourceProperty("prepStmtCacheSize", resource.getString("DS.prepStmtCacheSize"));
		CONFIG.addDataSourceProperty("prepStmtCacheSqlLimit", resource.getString("DS.prepStmtCacheSqlLimit"));

		CONFIG.addDataSourceProperty("useServerPrepStmts", resource.getString("DS.useServerPrepStmts"));
		CONFIG.addDataSourceProperty("useLocalSessionState", resource.getString("DS.useLocalSessionState"));
		CONFIG.addDataSourceProperty("rewriteBatchedStatements", resource.getString("DS.rewriteBatchedStatements"));
		CONFIG.addDataSourceProperty("cacheResultSetMetadata", resource.getString("DS.cacheResultSetMetadata"));
		CONFIG.addDataSourceProperty("cacheServerConfiguration", resource.getString("DS.cacheServerConfiguration"));
		CONFIG.addDataSourceProperty("elideSetAutoCommits", resource.getString("DS.elideSetAutoCommits"));
		CONFIG.addDataSourceProperty("maintainTimeStats", resource.getString("DS.maintainTimeStats"));
		dataSource = new HikariDataSource(CONFIG);
	}

	private DBConnector() {
	}
}
