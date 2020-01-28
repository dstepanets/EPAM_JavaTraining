package com.bank.controller;

import com.bank.console.View;
import com.bank.injector.ApplicationInjector;

public class MyController {

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
