package com.ssafy.in_class;

public class Magazine {
	private String isbn, title, author, publisher, desc;
	private int price, year, month;

	public int getYear() {
		return year;
	}

	public Magazine(String isbn, String title, String author, String publisher, String desc, int price, int year, int month) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.desc = desc;
		this.price = price;
		this.year = year;
		this.month = month;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getDesc() {
		return desc;
	}

	public int getPrice() {
		return price;
	}

	public int getMonth() {
		return month;
	}

	@Override
	public String toString() {
		return isbn + " \t| " + title + " \t| " + author + " \t| " + publisher + " \t| "
				+ price + " \t\t| " + desc + " \t\t| " + year + "." + month;
	}




}
