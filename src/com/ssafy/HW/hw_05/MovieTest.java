package com.ssafy.HW.hw_05;

import java.util.Scanner;

public class MovieTest {
	static Scanner sc = new Scanner(System.in);
	static MovieMgr manager = MovieMgr.getInstance();

	public static void main(String[] args) {
		int num = -1;
		do 
		{
			System.out.println("<<<�쁺�솕 愿�由� �봽濡쒓렇�옩>>>");
			System.out.println("1. �쁺�솕 �젙蹂� �엯�젰");
			System.out.println("2. �쁺�솕 �젙蹂� �쟾泥� 寃��깋");
			System.out.println("3. �쁺�솕紐� 寃��깋");
			System.out.println("4. �쁺�솕 �옣瑜대퀎 寃��깋");
			System.out.println("5. �쁺�솕 �젙蹂� �궘�젣");
			System.out.println("0. 醫낅즺");
			try {
				num = Integer.parseInt(sc.nextLine().trim());			
			} catch (Exception e)
			{
				System.out.println();
				System.out.println("�옒紐삳맂 �엯�젰�엯�땲�떎.");
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
				System.out.println("- �쁽�옱 ���옣�맂 �쁺�솕�뱾�엯�땲�떎.");
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
		System.out.println("---�쁺�솕 愿�由� �봽濡쒓렇�옩 醫낅즺---");
		sc.close();
	}
	
	public static void deleteMovieByName()
	{
		System.out.print("�궘�젣�븷 �쁺�솕紐낆쓣 �엯�젰�븯�꽭�슂: ");
		String title = sc.nextLine().trim();
		manager.delete(title);
		System.out.println();
		System.out.println("- �쁺�솕媛� �궘�젣�릺�뿀�뒿�땲�떎.");
	}
	
	public static void searchMovieByName()
	{
		System.out.print("寃��깋�븷 �쁺�솕紐낆쓣 �엯�젰�븯�꽭�슂: ");
		String tt = sc.nextLine().trim();
		Movie[] lst = manager.searchTitle(tt);
		System.out.println();
		if (lst.length == 0)
		{
			 System.out.println("- �빐�떦 �젣紐⑹쑝濡� �맂 �쁺�솕媛� �뾾�뒿�땲�떎.");
			 return;
		}
		System.out.println("- " +tt + "瑜� �젣紐⑹쑝濡� 寃��깋�맂 �쁺�솕�엯�땲�떎");
		for (Movie m : lst)
		{
			System.out.println(m);
		}
	}
	
	public static void searchMovieByGenere()
	{
		System.out.print("寃��깋�븷 �옣瑜대챸�쓣 �엯�젰�븯�꽭�슂: ");
		String genre = sc.nextLine().trim();
		Movie[] lst = manager.searchGenre(genre);
		System.out.println();
		if (lst.length == 0)
		{
			 System.out.println("�빐�떦 �젣紐⑹쑝濡� �맂 �쁺�솕媛� �뾾�뒿�땲�떎.");
			 return;
		}
		System.out.println(genre + "瑜� �옣瑜대줈 寃��깋�맂 �쁺�솕�엯�땲�떎");
		for (Movie m : lst)
		{
			System.out.println(m);
		}
	}

	
	public static void addMovie()
	{
		System.out.println("�엯�젰�븷 �쁺�솕 �젙蹂대�� �븣�젮二쇱꽭�슂.");
		System.out.print("�쁺�솕 �젣紐�: ");
		String title = sc.nextLine().trim();

		System.out.print("媛먮룆 �씠由�: ");
		String director = sc.nextLine().trim();

		int rating = -1;
		while (rating == -1)
		{
			System.out.print("蹂꾩젏(1~5): ");
			try {
				rating = Integer.parseInt(sc.nextLine().trim());
				if (rating < 1 || rating > 5)
				{
					rating = -1;
					System.out.println("�옒紐삳맂 �엯�젰�엯�땲�떎. �떎�떆 �엯�젰�빐二쇱꽭�슂.");
					continue;
				}
			} catch (Exception e)
			{
				System.out.println("�옒紐삳맂 �엯�젰�엯�땲�떎. �떎�떆 �엯�젰�빐二쇱꽭�슂.");
				continue;
			}
		}
		
		System.out.print("�쁺�솕 �옣瑜�: ");
		String genre = sc.nextLine().trim();

		System.out.print("�쁺�솕 �슂�빟(�샃�뀡): ");
		String summary = sc.nextLine().trim();

		Movie m = new Movie(title, director, rating, genre, summary);
		manager.add(m);	
		System.out.println();
		System.out.println("- �떎�쓬 �쁺�솕媛� �꽦怨듭쟻�쑝濡� �엯�젰�릺�뿀�뒿�땲�떎.");
		System.out.println(m);
	}
}
