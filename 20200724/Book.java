package com.ssafy.in_class;

public class Book {
	private String isbn, title, author, publisher, desc;
	private int price;

	
	public Book(String isbn, String title, String author, String publisher, String desc, int price) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.desc = desc;
		this.price = price;
	}


	@Override
	public String toString() {
		return isbn + " \t| " + title + " \t| " + author + " \t| " + publisher + " \t| "
				+ price + " \t| " + desc;
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
	
	
	
	

}
