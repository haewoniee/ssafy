package com.ssafy.HW.hw_11;


class ProductMgrTest {

	public static void main(String[] args) {
		IProductMgr mgr = ProductMgrImpl.getInstance();
		mgr.add(new TV(1,"TV1",1999.9, 10));
		mgr.add(new Refrigerator(2,"RF1",19999.9, 10));
		mgr.add(new TV(3,"TV2",4999.9, 10));
		mgr.add(new Refrigerator(4,"RF2",29999.9, 10));
		mgr.add(new TV(5,"TVSpecial1",99999.9, 10));
		mgr.add(new TV(6,"TVSpecial2",89999.9, 10));

//		mgr.makeReport();
		mgr.sendToServer();
	}

}
