package Credentials;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Jairun Diemert
 *
 */
public class ConnectDB {

	public static Connection getConnection() throws SQLException {
		Connection conn = null;

		try (FileInputStream f = new FileInputStream("db.properties")) {

			// load the properties file
			Properties pros = new Properties();
			pros.load(f);

			// assign db parameters
			final String driverName = pros.getProperty("driverName");
			final String dbURL = pros.getProperty("dbURL");

			// create a connection to the database
			Class.forName(driverName);
			conn = DriverManager.getConnection(dbURL);

		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

}
