package task2.ex2.model;

public class Book {
	private String name;
	private String author;
	private String publisher;
	private int year;
	private int pages;
	private int price;

	public Book(String name, String author, String publisher,
				int year, int pages, int price) {
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
		this.pages = pages;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getYear() {
		return year;
	}

	public int getPages() {
		return pages;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "{" +
				"name='" + name + '\'' +
				", author='" + author + '\'' +
				", publisher='" + publisher + '\'' +
				", year=" + year +
				", pages=" + pages +
				", price=" + price +
				'}';
	}
}



