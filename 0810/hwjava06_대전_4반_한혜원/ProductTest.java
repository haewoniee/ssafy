package com.ssafy.HW.hw_06;

public class ProductTest {

	public static void main(String[] args) {
		ProductMgr mgr = ProductMgr.getInstance();
		mgr.add(new TV(1,"TV1",1999.9, 10));
		mgr.add(new Refrigerator(2,"RF1",19999.9, 10));
		mgr.add(new TV(3,"TV2",4999.9, 10));
		mgr.add(new Refrigerator(4,"RF2",29999.9, 10));
		mgr.add(new TV(5,"TVSpecial1",99999.9, 10));
		mgr.add(new TV(6,"TVSpecial2",89999.9, 10));

		System.out.println("상품이 잘 저장되었는지 확인, listAll함수 확인");
		Product[] allProducts = mgr.listAll();
		for (int i = 0; i < allProducts.length; i++)
		{
			System.out.println(allProducts[i].toString());
		}
		
		System.out.println("상품번호로 검색하기");
		System.out.println(mgr.search(1));

		System.out.println("상품명으로 검색하기");
		Product[] resultSearch = mgr.search("TVSpecial");
		for (int i = 0; i < resultSearch.length; i++)
		{
			System.out.println(resultSearch[i].toString());
		}

		
		System.out.println("TV만 검색하기");
		TV[] resultT = mgr.getAllTVs();
		for (int i = 0; i < resultT.length; i++)
		{
			System.out.println(resultT[i].toString());
		}

		System.out.println("냉장고만 검색하기");
		Refrigerator[] resultR = mgr.getAllRefrigerators();
		for (int i = 0; i < resultR.length; i++)
		{
			System.out.println(resultR[i].toString());
		}
		
		System.out.println("상품번호로 삭제하기");
		mgr.delete(1);
		
		System.out.println("상품이 잘 삭제되었는지 확인, listAll함수 확인");
		allProducts = mgr.listAll();
		for (int i = 0; i < allProducts.length; i++)
		{
			System.out.println(allProducts[i].toString());
		}

		System.out.println("전체 재고 상품 금액을 구하기");
		System.out.println(mgr.totalPrice());
		
	}

}
