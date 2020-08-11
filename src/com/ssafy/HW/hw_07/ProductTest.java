package com.ssafy.HW.hw_07;

import java.util.ArrayList;

public class ProductTest {

	public static void main(String[] args) {
		ProductMgr mgr = ProductMgrImpl.getInstance();
		mgr.add(new TV(1,"TV1",1999.9, 10, 40));
		mgr.add(new Refrigerator(2,"RF1",19999.9, 10, 300));
		mgr.add(new TV(3,"TV2",4999.9, 10, 50));
		mgr.add(new Refrigerator(4,"RF2",29999.9, 10, 400));
		mgr.add(new Refrigerator(5,"RF3",29999.9, 10, 600));
		mgr.add(new TV(6,"TVSpecial1",99999.9, 10, 60));
		mgr.add(new TV(7,"TVSpecial2",89999.9, 10, 70));

		System.out.println("상품이 잘 저장되었는지 확인, listAll함수 확인");
		ArrayList<Product> allProducts = mgr.listAll();
		for (Product p : allProducts)
		{
			System.out.println(p.toString());
		}
		
		System.out.println("상품번호로 검색하기");
		System.out.println(mgr.search(1));

		System.out.println("상품명으로 검색하기");
		ArrayList<Product> resultSearch = mgr.search("TVSpecial");
		for (Product p : resultSearch)
		{
			System.out.println(p.toString());
		}

		
		System.out.println("50인치 넘는 TV만 검색하기");
		ArrayList<TV> resultT = mgr.getTVsBiggerThan50inch();
		for (Product p : resultT)
		{
			System.out.println(p.toString());
		}

		System.out.println("400L넘는 냉장고만 검색하기");
		ArrayList<Refrigerator> resultR = mgr.getRefsBiggerThan400L();
		for (Product p : resultR)
		{
			System.out.println(p.toString());
		}
		
		System.out.println("상품번호로 삭제하기");
		mgr.delete(1);
		
		System.out.println("상품이 잘 삭제되었는지 확인, listAll함수 확인");
		allProducts = mgr.listAll();
		for (Product p : allProducts)
		{
			System.out.println(p.toString());
		}
		
		System.out.println("전체 재고 상품 금액을 구하기");
		System.out.println(mgr.totalPrice());
		
	}

}
