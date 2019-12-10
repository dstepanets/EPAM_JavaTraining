package task2.ex2.controller;

import task2.ex2.model.Book;
import task2.ex2.view.Printer;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	private Scanner scan;
	private BooksManager manager;
	private Book[] books;

	public Menu(BooksManager manager, Book[] books) {
		this.scan = new Scanner(System.in);
		this.manager = manager;
		this.books = books;
	}

	void makeChoice() {
		System.out.print(":> ");
		while (!scan.hasNextInt()) {
			System.out.print(":> ");
			scan.next();
		}
		int choice = scan.nextInt();
		scan.nextLine();

		switch (choice) {
			case 1:
				booksByAuthor();
				break;
			case 2:
				booksByPublisher();
				break;
			case 3:
				booksByYear();
				break;
			case 4:
				sortByPublisher();
				break;
			case 0:
				System.exit(0);
				break;
		}
	}

	private void booksByAuthor() {
		String author = manager.authors[manager.rand.nextInt(manager.authors.length)];
		System.out.println("\n\tBooks by author: " + author);
		ArrayList<Book> set = manager.getBooksByAuthor(books, author);
		if (set.size() == 0) {
			System.out.println("Nothing was found :(");
		} else {
			Printer.printBooksArray(set.toArray());
		}
	}

	private void booksByPublisher() {
		String publisher = manager.publishers[manager.rand.nextInt(manager.publishers.length)];
		System.out.println("\n\tBooks by publisher: " + publisher);
		ArrayList<Book> set = manager.getBooksByPublisher(books, publisher);
		if (set.size() == 0) {
			System.out.println("Nothing was found :(");
		} else {
			Printer.printBooksArray(set.toArray());
		}
	}

	private void booksByYear() {
		int year  = manager.rand.nextInt(2020);
		System.out.println("\n\tBooks published later than: " + year);
		ArrayList<Book> set = manager.getBooksByYear(books, year);
		if (set.size() == 0) {
			System.out.println("Nothing was found :(");
		} else {
			Printer.printBooksArray(set.toArray());
		}
	}

	private void sortByPublisher() {
		System.out.println("\n\tSort by publisher:");
		manager.sortByPublisher(books);
		Printer.printBooksArray(books);
	}

}
