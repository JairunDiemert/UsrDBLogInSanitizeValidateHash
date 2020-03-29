package Credentials;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import bcrypt.HashPassword;
import regexp.Sanitize;
import regexp.Validate;

/**
 * @author Jairun Diemert
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// test DB connection
		try (Connection conn = ConnectDB.getConnection()) {

			// print out a message
			System.out.println(String.format("Connected to database %s " + "successfully.", conn.getCatalog()));
		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}

		// print menu
		boolean quit = false;
		String input;
		char menuItem;
		String userName;
		String password;
		int id;

		do {
			System.out.print("\nMake a selection       *All other enteries"
					+ " will end the program*\n________________\n" + "(C)reate New User\n(L)og In\n:");

			input = in.nextLine();
			input += ' ';
			menuItem = input.charAt(0);

			switch (menuItem) {

			case 'C':
			case 'c':
				System.out.print("\nYou've chosen to create a new user.\n\n" + "Enter User Name: ");
				userName = in.nextLine();
				System.out.print("Enter Password: ");
				password = in.nextLine();
				if (Validate.validate(password)) {
					id = InsertDB.insertUser(Sanitize.sanitize(userName),
							Sanitize.sanitize(HashPassword.hashPassword(password)));
					if (id > 0)
						System.out.println(String.format("\nA new user with id %d has been inserted.", id));
				} else {
					System.out
							.println("\nInvalid Password\n   The password must be between 10 and 32 characters long, \n"
									+ "and only consist of lowercase and uppercase letters, digits and \n"
									+ "the symbols &,%,$,#. At least one character of each of these four \n"
									+ "categories must be in the password.");
				}
				break;

			case 'L':
			case 'l':
				System.out.print("\nYou've chosen to log in.\n\n" + "Enter User Name: ");
				userName = in.nextLine();
				System.out.print("Enter Password: ");
				password = in.nextLine();

				if (ValidateUser.validateUser(Sanitize.sanitize(userName), Sanitize.sanitize(password)))
					System.out.println("WELCOME");
				else
					System.out.println("REJECTED");
				break;

			default:

				quit = true;

				break;

			}

		} while (!quit);

		System.out.println("Bye-bye!");
		in.close();
	}

}
