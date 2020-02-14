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
		if (dataSource == null) {
			setConfigs(DEFAULT_POPERTIES_FILE_PATH);
		}
		return dataSource.getConnection();
	}

	public static Connection getConnection(String propertiesFilePath) throws SQLException {
		if (dataSource == null) {
			setConfigs(propertiesFilePath);
		}
		return dataSource.getConnection();
	}

	private static void setConfigs(String propertiesFilePath) {
		ResourceBundle res = ResourceBundle.getBundle(propertiesFilePath);
		CONFIG.setJdbcUrl(res.getString("jdbcUrl"));
		CONFIG.setUsername(res.getString("username"));
		CONFIG.setPassword(res.getString("password"));
		CONFIG.setDriverClassName(res.getString("driverClassName"));
		CONFIG.setLeakDetectionThreshold(Integer.parseInt(res.getString("leakDetectionThreshold")));
		CONFIG.setMaximumPoolSize(Integer.parseInt(res.getString("maxPoolSize")));
		CONFIG.addDataSourceProperty("cachePrepStmts", res.getString("DS.cachePrepStmts"));
		CONFIG.addDataSourceProperty("prepStmtCacheSize", res.getString("DS.prepStmtCacheSize"));
		CONFIG.addDataSourceProperty("prepStmtCacheSqlLimit", res.getString("DS.prepStmtCacheSqlLimit"));

		CONFIG.addDataSourceProperty("useServerPrepStmts", res.getString("DS.useServerPrepStmts"));
		CONFIG.addDataSourceProperty("useLocalSessionState", res.getString("DS.useLocalSessionState"));
		CONFIG.addDataSourceProperty("rewriteBatchedStatements", res.getString("DS.rewriteBatchedStatements"));
		CONFIG.addDataSourceProperty("cacheResultSetMetadata", res.getString("DS.cacheResultSetMetadata"));
		CONFIG.addDataSourceProperty("cacheServerConfiguration", res.getString("DS.cacheServerConfiguration"));
		CONFIG.addDataSourceProperty("elideSetAutoCommits", res.getString("DS.elideSetAutoCommits"));
		CONFIG.addDataSourceProperty("maintainTimeStats", res.getString("DS.maintainTimeStats"));
		dataSource = new HikariDataSource(CONFIG);
	}

	private DBConnector() {
	}
}
