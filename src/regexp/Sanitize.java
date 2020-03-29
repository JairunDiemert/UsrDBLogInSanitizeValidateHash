package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jairun Diemert
 *
 */
public class Sanitize {
	public static String sanitize(String input) {
		String blackListRegex = "[\"(--);]";
		Pattern pat = Pattern.compile(blackListRegex);
		Matcher matcher = pat.matcher(input);
		String clean = matcher.replaceAll("?");
		return clean;
	}
}