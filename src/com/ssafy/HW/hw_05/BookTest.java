package com.ssafy.HW.hw_05;

public class BookTest {
	
	public static void main(String[] args) {
		System.out.println("********************************************** �룄�꽌 紐⑸줉 **********************************************");
		
		Book b1 = new Book("21424", "Java Pro", "源��븯�굹", "Jaen.kr", "Java 湲곕낯 臾몃쾿", 15000);
		Book b2 = new Book("35355", "遺꾩꽍�꽕怨�", "�냼�굹臾�", "Jaen.kr", "SW 紐⑤뜽留�", 30000);
		Magazine m1 = new Magazine("35535", "Java World", "�렪吏묐�", "java.com", "泥リ구�쓬", 7000, 2018, 2);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(m1);
		
	}
}
