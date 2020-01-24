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

import bank.controller.Controller;
import bank.domain.User;
import bank.injector.ApplicationInjector;
import bank.service.validator.ValidateException;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {

	private final ApplicationInjector injector = ApplicationInjector.getInstance();

	private Locale locale;
	private ResourceBundle rb;

	public void chooseLanguage() {

		System.out.println("1 - English (US)");
		System.out.println("2 - Українська (UA)");

		String language;
		String country;
		int option = Input.getInt("");
		switch (option) {
			case 2:
				language = "ua";
				country = "UA";
				break;
			default:
				language = "en";
				country = "US";
		}
		locale = new Locale(language, country);
		rb = ResourceBundle.getBundle("ConsoleMsg", locale);
	}

	public void loginMenu() {
		System.out.println(rb.getString("welcome"));
		System.out.println("\t" + rb.getString("loginMenu.1"));
		System.out.println("\t" + rb.getString("loginMenu.2"));
		System.out.println("\t" + rb.getString("loginMenu.3"));

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
				Controller.exitApp();
				break;
			default:
		}
	}

	private void logIn() {
		String email = Input.getLine(rb.getString("enter.email"));
		String password = Input.getLine(rb.getString("enter.password"));
		if (injector.getUserService().login(email, password)) {
			System.out.println(rb.getString("login.success"));
			Controller.confirmLogin();
		} else {
			System.out.println(rb.getString("login.fail"));
		}

	}

	private void register() {
		String email = Input.getLine(rb.getString("enter.email"));
		String password = Input.getLine(rb.getString("enter.password"));
		String phone = Input.getLine(rb.getString("enter.phone"));
		long id = injector.getUserRepository().count();
		User user = User.builder()
				.setId(id)
				.setEmail(email)
				.setPassword(password)
				.setPhone(phone)
				.build();
		try {
			injector.getUserService().register(user);
			System.out.println(rb.getString("registration.success"));
		} catch (ValidateException e) {
			System.err.println(e.getMessage());
			System.out.println(rb.getString("registration.fail"));
		}
	}


	public void mainMenu() {
		System.out.println("\t1 - " + rb.getString("op.1"));
		System.out.println("\t2 - " + rb.getString("op.2"));
		System.out.println("\t3 - " + rb.getString("op.3"));
		System.out.println("\t0 - " + rb.getString("op.0"));

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
				Controller.exitApp();
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
