package com.ssafy.HW.hw_07;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductMgrImpl implements ProductMgr {

	private ArrayList<Product> productList;
	
	private static ProductMgrImpl mgr = new ProductMgrImpl();
	
	private ProductMgrImpl() {
		productList = new ArrayList<Product>();
	}
	
	public static ProductMgrImpl getInstance()
	{
		return mgr;
	}
	
	@Override
	public void add(Product p) {
		productList.add(p);
	}

	@Override
	public ArrayList<Product> listAll() {
		ArrayList<Product> plist = new ArrayList<Product>();
		for (Product p : productList)
		{
			plist.add(p);
		}
		return plist;
	}

	@Override
	public Product search(int pid) {
		for (Product p : productList)
		{
			if (p.getPid() == pid)
			{
				return p;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Product> search(String name) {
		ArrayList<Product> toReturn = new ArrayList<Product>();
		
		for (Product p : productList)
		{
			if (p.getName().contains(name))
			{
				toReturn.add(p);
			}
		}
		return toReturn;
	}

	@Override
	public ArrayList<Refrigerator> getRefsBiggerThan400L() {
		ArrayList<Refrigerator> toReturn = new ArrayList<Refrigerator>();
		for (Product p : productList)
		{
			if (p instanceof Refrigerator)
			{
				Refrigerator r = (Refrigerator) p;
				if (r.getVolume() >= 400)
				{
					toReturn.add(r);
				}
			}
		}
		return toReturn;
	}

	@Override
	public ArrayList<TV> getTVsBiggerThan50inch() {
		ArrayList<TV> toReturn = new ArrayList<TV>();
		for (Product p : productList)
		{
			if (p instanceof TV)
			{
				TV t = (TV) p;
				if (t.getSize() >= 50)
				{
					toReturn.add(t);
				}
			}
		}
		return toReturn;
	}

	@Override
	public void modifyPrice(int pid, double price) {
		search(pid).setPrice(price);
	}

	@Override
	public void delete(int pid) {
		for (Iterator<Product> it = productList.iterator(); it.hasNext();)
		{
			Product p = it.next();
			if (p.getPid() == pid)
			{
				it.remove();
				break;
			}
		}
	}

	@Override
	public double totalPrice() {
		double total = 0;
		for (Product p : productList)
		{
			total += p.getPrice();
		}
		return total;
	}

}
