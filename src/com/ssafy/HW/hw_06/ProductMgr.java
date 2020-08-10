package com.ssafy.HW.hw_06;


public class ProductMgr {
	
	private Product[] products;
	private int MAX_PRODUCT_NUM = 10000;
	private final static ProductMgr mgr = new ProductMgr();
	private int idx = 0;
	
	private ProductMgr() {
		products = new Product[MAX_PRODUCT_NUM];
	}
	
	public static ProductMgr getInstance()
	{
		return mgr;
	}
	
	public void add(Product p)
	{
		products[idx] = p;
		idx++;
	}
	
	public Product[] listAll()
	{
		Product[] toReturn = new Product[idx];
		for (int i = 0; i < idx; i++)
		{
			toReturn[i] = products[i];
		}
		return toReturn;
	}
	
	public Product search(int pid)
	{
		for (int i = 0; i < idx; i++)
		{
			if (products[i].getPid() == pid)
			{
				return products[i];
			}
		}
		return null;
	}
	
	public Product[] search(String name)
	{
		int cnt = 0;
		for (int i = 0; i < idx; i++)
		{
			if (products[i].getName().contains(name))
			{
				cnt++;
			}
		}
		Product[] toReturn = new Product[cnt];
		cnt = 0;
		for (int i = 0; i < idx; i++)
		{
			if (products[i].getName().contains(name))
			{
				toReturn[cnt] = products[i];
				cnt++;
			}
		}
		return toReturn;
	}
	
	public TV[] getAllTVs()
	{
		int cnt = 0;
		for (int i = 0; i < idx; i++)
		{
			if (products[i] instanceof TV)
			{
				cnt++;
			}
		}
		TV[] toReturn = new TV[cnt];
		cnt = 0;
		for (int i = 0; i < idx; i++)
		{
			if (products[i] instanceof TV)
			{
				toReturn[cnt] = (TV) products[i];
				cnt++;
			}
		}
		return toReturn;
	}
	
	public Refrigerator[] getAllRefrigerators()
	{
		int cnt = 0;
		for (int i = 0; i < idx; i++)
		{
			if (products[i] instanceof Refrigerator)
			{
				cnt++;
			}
		}
		Refrigerator[] toReturn = new Refrigerator[cnt];
		cnt = 0;
		for (int i = 0; i < idx; i++)
		{
			if (products[i] instanceof Refrigerator)
			{
				toReturn[cnt] = (Refrigerator) products[i];
				cnt++;
			}
		}
		return toReturn;
	}
	
	public void delete(int pid)
	{
		if (search(pid) != null)
		{
			idx--;
			Product[] newArr = new Product[idx];
			int i = 0;
			for (; i < idx; i++)
			{
				if (products[i].getPid() == pid)
				{
					break;
				}
				else
				{
					newArr[i] = products[i];
				}
			}
			for (; i < idx; i++)
			{
				newArr[i] = products[i+1];
			}
			products = newArr;
		}		
	}
	
	public long totalPrice()
	{
		long total = 0;
		for (int i = 0; i < idx; i++)
		{
			total += products[i].getPrice();
		}
		return total;
	}
	
	
	
}
