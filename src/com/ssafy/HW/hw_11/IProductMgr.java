package com.ssafy.HW.hw_11;


public interface IProductMgr {
	
	public void add(Product p);	
	
	public Product[] listAll();
	
	public Product search(int pid);
	
	public Product[] search(String name);
	
	public TV[] getAllTVs();
	
	public Refrigerator[] getAllRefrigerators();
	
	public void delete(int pid);
	
	public long totalPrice();
	
	public void makeReport();
	
	public void sendToServer();

}
