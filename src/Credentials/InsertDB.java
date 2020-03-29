package Credentials;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Jairun Diemert
 *
 */
public class InsertDB {
	public static int insertUser(String user, String password) {
		// for insert a new user
		ResultSet rs = null;
		int UserId = 0;

		String sql = "INSERT INTO Credentials(UName,Passwd) " + "VALUES(?,?)";

		try (Connection conn = ConnectDB.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

			// set parameters for statement
			pstmt.setString(1, user);
			pstmt.setString(2, password);

			int rowAffected = pstmt.executeUpdate();
			if (rowAffected == 1) {
				// get candidate id
				rs = pstmt.getGeneratedKeys();
				if (rs.next())
					UserId = rs.getInt(1);

			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return UserId;
	}

}
