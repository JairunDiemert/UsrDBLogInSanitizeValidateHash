package Credentials;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bcrypt.CheckPassword;

/**
 * @author Jairun Diemert
 *
 */
public class ValidateUser {

	public static boolean validateUser(String user, String password) {

		try (Connection conn = ConnectDB.getConnection()) {
			String sql = "SELECT * from Credentials WHERE UName = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				if (CheckPassword.checkPassword(password, rs.getString(3)))
					return true;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		return false;
	}
}