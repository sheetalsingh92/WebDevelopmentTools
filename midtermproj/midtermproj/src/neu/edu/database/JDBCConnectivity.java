package neu.edu.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCConnectivity {

	private static Connection conn;

	private JDBCConnectivity() {

	}

	private static String hostName = "localhost";
	private static String dbName = "midterm";
	private static String userName = "root";
	private static String password = null;

	public static Connection getConnection() {

		try {
			if (conn == null || conn.isClosed()) {
				// Step 1: Register Driver
				try {
					Class.forName("com.mysql.jdbc.Driver");

					// Step 2: Create connectivity URL
					String connectionURL = "jdbc:mysql://" + hostName + ":3308/" + dbName;
					// Step 3: Open Connection
					conn = DriverManager.getConnection(connectionURL, userName, password);

					// Step 4: Handle Error
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("Driver Not Found");
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Connectivity Issue");
					e.printStackTrace();
				}
				System.out.println("Created Connection");

			} else {
				System.out.println("Reusing Connection");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection not handled");
		}
		return conn;

	}

	

}
