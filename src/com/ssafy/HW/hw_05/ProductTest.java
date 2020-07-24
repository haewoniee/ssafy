package com.ssafy.HW.hw_05;


class ProductTest {

	public static void main(String[] args) {
		ProductMgr mgr = ProductMgr.getInstance();
		
		mgr.add(new Product(1,"aa",13.0f,10));
		mgr.add(new Product(11,"aaa",14.0f,11));
		mgr.add(new Product(2,"aaa",15.0f,12));
		mgr.add(new Product(21,"aaa",12.5f,12));
		mgr.list();
		System.out.println();
		mgr.list(1);
		System.out.println();
		mgr.delete(11);
		mgr.priceList(13);
	}
}
