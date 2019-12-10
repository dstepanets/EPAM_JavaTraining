package task2.ex2.view;

import task2.ex2.model.Book;

public class Printer {

	public static void printBooksArray(Object[] books) {
		int i = 0;
		for (Object b : books) {
			System.out.println(++i + ". " + b);
		}
	}

	public static void printMenu() {
		System.out.println("\nChoose an option (type number and press Enter):");
		System.out.println("1. Get books by author");
		System.out.println("2. Get books by publisher");
		System.out.println("3. Get books by year of publishing");
		System.out.println("4. Sort books by publisher");
		System.out.println("0. Exit the program.");
	}
}
