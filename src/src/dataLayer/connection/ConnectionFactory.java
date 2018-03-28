package dataLayer.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

public class ConnectionFactory implements DatabaseConnectionInterface {

	private static final String DBURL = "jdbc:mysql://localhost/studentmanagement?autoReconnect=true&useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "root";
	
	
	private static ConnectionFactory singleInstance=new ConnectionFactory();
	
	private ConnectionFactory() {
		
	}

	
	@Override
	public Connection connect() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBURL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;	
	}
	
	public static Connection getConnection() {
		return singleInstance.connect();
	}

	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

}
