package com.ssafy.lecture.java.ws06;


public class BookManager {

	private static final BookManager mgr = new BookManager();
	private Book[] books;
	private int MAX_BOOKS = 10000;
	private int idx;

	private BookManager() {	
		books = new Book[MAX_BOOKS];
	}
	
	public static BookManager getInstance() {
		return mgr;
	}
	
	public void add(Book b)
	{
		if (idx >= 0 && idx < MAX_BOOKS)
		{
			books[idx] = b;
			idx++;
		}
		else
		{
			System.out.println("더이상 책을 추가할 수 없습니다.");
		}
	}
	
	public Book[] searchAll()
	{
		Book[] toReturn = new Book[idx];
		for (int i = 0; i < idx; i++)
		{
			toReturn[i] = books[i].clone();
		}
		return toReturn;
	}
	
	public Book searchIsbn(long isbn)
	{
		for (int i = 0; i < idx; i++)
		{
			if (books[i].getIsbn() == isbn)
			{
				return books[i].clone();
			}
		}
		System.out.println("isbn(" + isbn + ")으로 검색한 도서가 없습니다.");
		return null;
	}
	
	public Book[] searchTitle(String title)
	{
		int cnt = 0;
		for (int i = 0; i < idx; i++)
		{
			if (books[i].getTitle().contains(title))
			{
				cnt++;
			}
		}
		if (cnt == 0)
		{
			System.out.println("제목(" + title + ")으로 검색한 도서가 없습니다.");
			return null;
		}
		Book[] toReturn = new Book[cnt];
		cnt = 0;
		for (int i = 0; i < idx; i++)
		{
			if (books[i].getTitle().contains(title))
			{
				toReturn[cnt] = books[i].clone();
				cnt++;
			}
		}
		return toReturn;
	}
	
	public Book[] searchBook()
	{
		int cnt = 0;
		for (int i = 0; i < idx; i++)
		{
			if (!(books[i] instanceof Magazine))
			{
				cnt++;
			}
		}

		Book[] toReturn = new Book[cnt];
		cnt = 0;
		for (int i = 0; i < idx; i++)
		{
			if (!(books[i] instanceof Magazine))
			{
				toReturn[cnt] = books[i].clone();
			}
		}
		return toReturn;
	}
	
	public Magazine[] searchMagazine()
	{
		int cnt = 0;
		for (int i = 0; i < idx; i++)
		{
			if (books[i] instanceof Magazine)
			{
				cnt++;
			}
		}

		Magazine[] toReturn = new Magazine[cnt];
		cnt = 0;
		for (int i = 0; i < idx; i++)
		{
			if (books[i] instanceof Magazine)
			{
				toReturn[cnt] = (Magazine) books[i].clone();
			}
		}
		return toReturn;
	}
	
	public Book[] searchPublisher(String name)
	{
		int cnt = 0;
		for (int i = 0; i < idx; i++)
		{
			if (books[i].getTitle().contains(name))
			{
				cnt++;
			}
		}
		if (cnt == 0)
		{
			System.out.println("출판사(" + name + ")으로 검색한 도서가 없습니다.");
			return null;
		}
		Book[] toReturn = new Book[cnt];
		cnt = 0;
		for (int i = 0; i < idx; i++)
		{
			if (books[i].getTitle().contains(name))
			{
				toReturn[cnt] = books[i].clone();
				cnt++;
			}
		}
		return toReturn;
	}
	
	public Book[] searchPriceLower(long price)
	{
		int cnt = 0;
		for (int i = 0; i < idx; i++)
		{
			if (books[i].price <= price)
			{
				cnt++;
			}
		}
		if (cnt == 0)
		{
			System.out.println("가격(" + price + ")보다 낮은 가격의 도서가 없습니다.");
			return null;
		}
		Book[] toReturn = new Book[cnt];
		cnt = 0;
		for (int i = 0; i < idx; i++)
		{
			if (books[i].price <= price)
			{
				toReturn[cnt] = books[i].clone();
				cnt++;
			}
		}
		return toReturn;
	}
	
	public long totalPrice()
	{
		long total = 0;
		for (int i = 0; i < idx; i++)
		{
			total += books[i].price;
		}
		return total;
	}
	
	public long priceAvg()
	{
		long total = 0;
		for (int i = 0; i < idx; i++)
		{
			total += books[i].price;
		}
		return total/(long)idx;
	}

}
