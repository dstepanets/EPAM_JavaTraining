package bank.controller;

import bank.console.View;
import bank.injector.ApplicationInjector;

public class Controller {

	private final ApplicationInjector injector = ApplicationInjector.getInstance();
	private final View view = new View();
	private static boolean isLoggedIn = false;

	public void run() {

		view.chooseLanguage();

		while(true) {
			if (!isLoggedIn) {
				view.loginMenu();
			} else {
				view.mainMenu();
			}
		}

	}

	public static void exitApp() {
		System.exit(0);
	}

	public static void confirmLogin() {
		isLoggedIn = true;
	}




}
