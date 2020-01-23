package bank;

import bank.console.View;
import bank.injector.ApplicationInjector;
import bank.service.UserService;

import java.util.Arrays;
import java.util.List;

public class ConsoleApp {

	private static boolean isLoggedIn = false;

	public static void main(String[] args) {

		ApplicationInjector injector = ApplicationInjector.getInstance();
		View view = new View();

		while (true) {
			if (!isLoggedIn) {
				view.loginMenu();
			} else {
				view.mainMenu();
			}
		}

	}

	public static void confirmLogin() {
		isLoggedIn = true;
	}

	public static void exitApp() {
		System.exit(0);
	}






	/*	-	-	-	-	-	-	-	-	-	-	-	-	-	*/

	private static void lectureTest() {
		ApplicationInjector injector = ApplicationInjector.getInstance();
		final UserService userService = injector.getUserService();
		final boolean password = userService.login("alex@gmail.com", "password");
		System.out.println(password);

		List<String> list = Arrays.asList("one", "three", "five", "123456789");
		final Integer integer = list.stream()
				.map(String::length)
				.max(Integer::compareTo)
				.orElse(0);
		System.out.println(integer);
	}

}
