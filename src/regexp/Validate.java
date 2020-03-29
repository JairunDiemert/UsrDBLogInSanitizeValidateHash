package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jairun Diemert
 *
 */
public class Validate {

	public static boolean validate(String input) {
		String regex = "((?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[&%$#]).{10,32})";
		Pattern pat = Pattern.compile(regex);
		Matcher matcher = pat.matcher(input);
		return matcher.matches();
	}

}