package task2.ex2.controller;

import task2.ex2.model.Book;
import task2.ex2.view.Printer;

public class Main {

	public static void main(String[] args) {
		BooksManager manager =  new BooksManager();
		Book[] books = manager.generateBookArray(10);
		Menu menu = new Menu(manager, books);

		Printer.printBooksArray(books);
		Printer.printMenu();

		while (true) {
			menu.makeChoice();
		}
	}

}
