package thai.main.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	public static Connection makeConnection() {
		// Database connection parameters
		String URL = "jdbc:mysql://localhost:3307/be-7"; // Database URL
		String USER = "root"; // Database username
		String PASSWORD = "Ttyyuu11.."; // Database password

		// Establish connection
//		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
//		if we do this the connection will be closed after being used in the brackets

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connection successful!");
			return conn;
		} catch (SQLException e) {
			System.err.println("Connection failed: " + e.getMessage());
		}
		return null;
	}
}
