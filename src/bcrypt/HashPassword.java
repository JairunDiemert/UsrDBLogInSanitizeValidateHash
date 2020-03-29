package bcrypt;

import org.mindrot.BCrypt;

/**
 * @author Jairun Diemert
 *
 */
public class HashPassword {
	public static String hashPassword(String plaintext_password) {

		String salt = BCrypt.gensalt(12);
		String hashed = BCrypt.hashpw(plaintext_password, salt);

		return hashed;
	}

}
