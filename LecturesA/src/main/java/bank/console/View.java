package bank.console;

/*
 * 1 - to login
 * 2 - register
 * 3 - exit
 *
 * -------
 * 1 - find all users
 * 2 - find by id
 * 3 - find by email
 */

import bank.ConsoleApp;
import bank.domain.User;
import bank.injector.ApplicationInjector;

public class View {

	private final ApplicationInjector injector = ApplicationInjector.getInstance();

	public void loginMenu() {
		System.out.println("Welcome to Gang Bank!");
		System.out.println("(enter a number to choose an option)");
		System.out.println("\t1 - log in");
		System.out.println("\t2 - register");
		System.out.println("\t3 - exit");

		int option;
		do {
			option = Input.getInt("");
		} while (option < 1 || option > 3);

		switch (option) {
			case 1:
				logIn();
				break;
			case 2:
				register();
				break;
			case 3:
				ConsoleApp.exitApp();
				break;
			default:
		}
	}

	private void logIn() {
		String email = Input.getLine("Enter your email address");
		String password = Input.getLine("Enter your password");
		if (injector.getUserService().login(email, password)) {
			System.out.println("You are logged in!");
			ConsoleApp.confirmLogin();
		} else {
			System.out.println("Wrong credentials:(");
		}

	}

	private void register() {
		String email = Input.getLine("Enter your email address");
		String password = Input.getLine("Enter your password");
		String phone = Input.getLine("Enter your phone number");
		long id = injector.getUserRepository().count();
		User user = User.builder()
				.setId(id)
				.setEmail(email)
				.setPassword(password)
				.setPhone(phone)
				.build();
		injector.getUserService().register(user);
	}

	public static void registrationOutcome(boolean success) {
		if (success) {
			System.out.println("User is registered. You can log in.");
		} else {
			System.out.println("Registration failed. Try once more.");
		}
	}

	public void mainMenu() {
		System.out.println("Choose operation:");
		System.out.println("\t1 - list all users");
		System.out.println("\t2 - find user by ID");
		System.out.println("\t3 - find user be email");
		System.out.println("\t0 - EXIT");

		int option;
		do {
			option = Input.getInt("");
		} while (option < 0 || option > 3);

		switch (option) {
			case 1:
				findAll();
				break;
			case 2:
				findById();
				break;
			case 3:
				findByEmail();
				break;
			case 0:
				ConsoleApp.exitApp();
				break;
			default:
		}
	}

	private void findAll() {
		System.out.println("UNDER CONSTRUCTION");
	}

	private void findById() {
		System.out.println("UNDER CONSTRUCTION");
	}

	private void findByEmail() {
		System.out.println("UNDER CONSTRUCTION");
	}

}
