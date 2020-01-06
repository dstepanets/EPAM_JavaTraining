package task2.ex2.controller;

import task2.ex2.model.Book;
import task2.ex2.model.BookPublisherComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class BooksManager {

	Random rand = new Random();
	String[] authors = {"God", "Ivan Franko", "Tarash Shevchenko",
			"Lesya Ukrainka", "Mykola Gogol", "Homer", "NoName",
			"George Orwell", "J.R.R. Tolkien", "Victor Hugo"};
	String[] publishers = {"Johannes Gutenberg", "Penguin", "O'Reilly",
			"Oxford University Press", "Samvydav", "A-ba-ba-ga-la-ma-ga",
			"Astrolabia", "Perun", "Veselka", "Xerox"};


	Book[] generateBookArray(int num) {
		Book[] books = new Book[num];
		for (int i = 0; i < num; i++) {
			String name = generateRandomString(rand.nextInt(17) + 3);
			String author = authors[rand.nextInt(authors.length)];
			String publisher = publishers[rand.nextInt(publishers.length)];
			int year = rand.nextInt(2020);
			int pages = rand.nextInt(1200);
			int price = rand.nextInt(1000);
			books[i] = new Book(name, author, publisher, year, pages, price);
		}
		return books;
	}


	private String generateRandomString(int n) {
		char[] array = new char[n]; // length is bounded by n
		for (int i = 0; i < n; i++) {
			array[i] = (char) (rand.nextInt(26) + 97);
		}
		return String.valueOf(array);
	}

	ArrayList<Book> getBooksByAuthor(Book[] books, String author) {
		ArrayList<Book> result = new ArrayList<>();
		for (Book b : books) {
			if (b.getAuthor().equals(author)) {
				result.add(b);
			}
		}
		return result;
	}

	ArrayList<Book> getBooksByPublisher(Book[] books, String publisher) {
		ArrayList<Book> result = new ArrayList<>();
		for (Book b : books) {
			if (b.getPublisher().equals(publisher)) {
				result.add(b);
			}
		}
		return result;
	}

	ArrayList<Book> getBooksByYear(Book[] books, int year) {
		ArrayList<Book> result = new ArrayList<>();
		for (Book b : books) {
			if (b.getYear() > year) {
				result.add(b);
			}
		}
		return result;
	}

	void sortByPublisher(Book[] books) {
		Arrays.sort(books, new Comparator<Book>() {
			@Override
			public int compare(Book b1, Book b2) {
				return b1.getPublisher().compareTo(b2.getPublisher());
			}
		});
	}

	void sortByAuthor(Book[] books) {
		Arrays.sort(books, new Comparator<Book>() {
			@Override
			public int compare(Book b1, Book b2) {
				return b1.getAuthor().compareTo(b2.getAuthor());
			}
		});
	}

}
