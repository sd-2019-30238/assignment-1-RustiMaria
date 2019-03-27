package assignment.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
		String hostName = "localhost";
		String dbName = "assignment";
		String username = "root";
		String password = "root";
		return getMySQLConnection(hostName, dbName, username, password);
	}

	public static Connection getMySQLConnection(String hostName, String dbName, String username, String password) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");

		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

		Connection conn = DriverManager.getConnection(connectionURL, username, password);
		System.out.println("Connected successfully!");
		
		return conn;
	}

}
