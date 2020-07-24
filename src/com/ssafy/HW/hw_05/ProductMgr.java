package com.ssafy.HW.hw_05;

public class ProductMgr {
	private Product[] prodArr = new Product[100000];
	private int idx;
	
	//Singleton
	private static ProductMgr mgr = new ProductMgr();
	
	private ProductMgr() {};
	
	public static ProductMgr getInstance()
	{
		return mgr;
	}
	
	public void add(Product p)
	{
		prodArr[idx] = p;
		idx++;
	}
	
	public void list()
	{
		for (int i = 0; i < idx; i++)
		{
			System.out.println(prodArr[i]);
		}
	}
	
	public void list(int num)
	{
		for (int i = 0; i < idx; i++)
		{
			if (prodArr[i].getPid() == num)
			{
				System.out.println(prodArr[i]);
			}
		}
	}
	
	public void delete(int num)
	{
		int i;
		for (i = 0; i < idx; i++)
		{
			if (prodArr[i].getPid() == num)
			{
				break;
			}
		}
		for (i = i+1; i < idx; i++)
		{
			prodArr[i-1] = prodArr[i];
		}
		idx--;
		prodArr[idx] = null;

	}
	
	public void priceList(int price)
	{
		for (int i = 0; i < idx; i++)
		{
			if (prodArr[i].getPrice() <= (float) price)
			{
				System.out.println(prodArr[i]);
			}
		}

	}
}
