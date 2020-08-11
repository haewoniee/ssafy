package com.ssafy.HW.hw_07;

import java.util.ArrayList;

public interface ProductMgr {
	
	public void add(Product p);
	
	public ArrayList<Product> listAll();
	
	public Product search(int pid);
	
	public ArrayList<Product> search(String name);
	
	public ArrayList<Refrigerator> getRefsBiggerThan400L();
	
	public ArrayList<TV> getTVsBiggerThan50inch();
	
	public void modifyPrice(int pid, double price);
	
	public void delete(int pid);
	
	public double totalPrice();
	
}
