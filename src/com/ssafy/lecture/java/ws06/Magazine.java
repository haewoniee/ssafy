package com.ssafy.lecture.java.ws06;

public class Magazine extends Book {

	private String year, month;
	
	public Magazine(long isbn, String title, String author, String publisher, 
			double price, String desc, String year, String month) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}

	public Magazine(long isbn, String title, String author, String publisher, 
			double price, String year, String month) {
		this(isbn, title, author, publisher, price, "", year, month);
	}

	public Magazine clone() {
		Magazine m = (Magazine)super.clone();
		m.year = this.year;
		m.month = this.month;
		return m;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
}
