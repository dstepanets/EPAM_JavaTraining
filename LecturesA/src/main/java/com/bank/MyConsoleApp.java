package com.bank;

import com.bank.controller.MyController;

public class MyConsoleApp {

	public static void main(String[] args) {

		MyController myController = new MyController();
		myController.run();

	}

	/*	-	-	-	-	-	-	-	-	-	-	-	-	-	*/

//	private static void lectureTest() {
//		ApplicationInjector injector = ApplicationInjector.getInstance();
//		final UserService userService = injector.getUserService();
//		final boolean password = userService.login("alex@gmail.com", "password");
//		System.out.println(password);
//
//		List<String> list = Arrays.asList("one", "three", "five", "123456789");
//		final Integer integer = list.stream()
//				.map(String::length)
//				.max(Integer::compareTo)
//				.orElse(0);
//		System.out.println(integer);
//	}

}
