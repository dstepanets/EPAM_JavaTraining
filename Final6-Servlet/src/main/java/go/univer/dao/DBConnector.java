package go.univer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnector {
	private final String url;
	private final String user;
	private final String password;

	public DBConnector(String filename) {
		ResourceBundle resource = ResourceBundle.getBundle(filename);
		this.url = resource.getString("db.url");
		this.user = resource.getString("db.user");
		this.password = resource.getString("db.password");
	}

	public DBConnector() {
		this("database.properties");
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
}
