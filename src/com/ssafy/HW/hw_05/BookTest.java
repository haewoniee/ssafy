package com.ssafy.in_class;

public class BookTest {
	
	public static void main(String[] args) {
		System.out.println("********************************************** 도서 목록 **********************************************");
		
		Book b1 = new Book("21424", "Java Pro", "김하나", "Jaen.kr", "Java 기본 문법", 15000);
		Book b2 = new Book("35355", "분석설계", "소나무", "Jaen.kr", "SW 모델링", 30000);
		Magazine m1 = new Magazine("35535", "Java World", "편집부", "java.com", "첫걸음", 7000, 2018, 2);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(m1);
		
	}
}
