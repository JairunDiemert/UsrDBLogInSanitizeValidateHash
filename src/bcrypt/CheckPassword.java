package bcrypt;

import org.mindrot.BCrypt;

/**
 * @author Jairun Diemert
 *
 */
public class CheckPassword {

	public static boolean checkPassword(String password_plaintext, String stored_hash) {
		if (stored_hash == null || !stored_hash.startsWith("$2a$"))
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

		return BCrypt.checkpw(password_plaintext, stored_hash);
	}

}
