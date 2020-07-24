package com.ssafy.in_class;

import java.util.Scanner;

public class MovieTest {
	static Scanner sc = new Scanner(System.in);
	static MovieMgr manager = MovieMgr.getInstance();

	public static void main(String[] args) {
		int num = -1;
		do 
		{
			System.out.println("<<<영화 관리 프로그램>>>");
			System.out.println("1. 영화 정보 입력");
			System.out.println("2. 영화 정보 전체 검색");
			System.out.println("3. 영화명 검색");
			System.out.println("4. 영화 장르별 검색");
			System.out.println("5. 영화 정보 삭제");
			System.out.println("0. 종료");
			try {
				num = Integer.parseInt(sc.nextLine().trim());			
			} catch (Exception e)
			{
				System.out.println();
				System.out.println("잘못된 입력입니다.");
				System.out.println();
				continue;
			}
			switch (num)
			{
			case 1:
				addMovie();
				break;
			case 2:
				System.out.println();
				System.out.println("- 현재 저장된 영화들입니다.");
				for (Movie m : manager.search())
				{
					System.out.println(m);
				}
				break;
			case 3:
				searchMovieByName();
				break;
			case 4:
				searchMovieByGenere();
				break;
			case 5:
				deleteMovieByName();
				break;
			}
			System.out.println();
		} while (num != 0);
		System.out.println("---영화 관리 프로그램 종료---");
		sc.close();
	}
	
	public static void deleteMovieByName()
	{
		System.out.print("삭제할 영화명을 입력하세요: ");
		String title = sc.nextLine().trim();
		manager.delete(title);
		System.out.println();
		System.out.println("- 영화가 삭제되었습니다.");
	}
	
	public static void searchMovieByName()
	{
		System.out.print("검색할 영화명을 입력하세요: ");
		String tt = sc.nextLine().trim();
		Movie[] lst = manager.searchTitle(tt);
		System.out.println();
		if (lst.length == 0)
		{
			 System.out.println("- 해당 제목으로 된 영화가 없습니다.");
			 return;
		}
		System.out.println("- " +tt + "를 제목으로 검색된 영화입니다");
		for (Movie m : lst)
		{
			System.out.println(m);
		}
	}
	
	public static void searchMovieByGenere()
	{
		System.out.print("검색할 장르명을 입력하세요: ");
		String genre = sc.nextLine().trim();
		Movie[] lst = manager.searchGenre(genre);
		System.out.println();
		if (lst.length == 0)
		{
			 System.out.println("해당 제목으로 된 영화가 없습니다.");
			 return;
		}
		System.out.println(genre + "를 장르로 검색된 영화입니다");
		for (Movie m : lst)
		{
			System.out.println(m);
		}
	}

	
	public static void addMovie()
	{
		System.out.println("입력할 영화 정보를 알려주세요.");
		System.out.print("영화 제목: ");
		String title = sc.nextLine().trim();

		System.out.print("감독 이름: ");
		String director = sc.nextLine().trim();

		int rating = -1;
		while (rating == -1)
		{
			System.out.print("별점(1~5): ");
			try {
				rating = Integer.parseInt(sc.nextLine().trim());
				if (rating < 1 || rating > 5)
				{
					rating = -1;
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
					continue;
				}
			} catch (Exception e)
			{
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				continue;
			}
		}
		
		System.out.print("영화 장르: ");
		String genre = sc.nextLine().trim();

		System.out.print("영화 요약(옵션): ");
		String summary = sc.nextLine().trim();

		Movie m = new Movie(title, director, rating, genre, summary);
		manager.add(m);	
		System.out.println();
		System.out.println("- 다음 영화가 성공적으로 입력되었습니다.");
		System.out.println(m);
	}
}
