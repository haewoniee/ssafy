package com.ssafy.HW.hw_11;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;


public class ProductMgrImpl implements IProductMgr {

	private ArrayList<Product> list;
	private int size;

	// 싱글톤
	static ProductMgrImpl mgr = new ProductMgrImpl();

	private ProductMgrImpl() {
		list = new ArrayList<Product>();
	}

	public static ProductMgrImpl getInstance() {
		return mgr;
	}

	@Override
	public void add(Product p) {
		list.add(p);
		size++;
	}

	@Override
	public Product[] listAll() {
		Product[] res = new Product[size];
		for (int i = 0; i < size; i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	@Override
	public Product search(int pid) {
		for (Product p : list) {
			if (p.getPid() == pid) {
				return p;
			}
		}
		return null;
	}

	@Override
	public Product[] search(String name) {
		ArrayList<Product> toReturn = new ArrayList<Product>();

		for (Product p : list) {
			if (p.getName().contains(name)) {
				toReturn.add(p);
			}
		}
		return (Product[]) toReturn.toArray();
	}

	@Override
	public TV[] getAllTVs() {
		int cnt = 0;
		for (int i = 0; i < size; i++)
		{
			if (list.get(i) instanceof TV)
			{
				cnt++;
			}
		}
		TV[] toReturn = new TV[cnt];
		cnt = 0;
		for (int i = 0; i < size; i++)
		{
			if (list.get(i) instanceof TV)
			{
				toReturn[cnt] = (TV) list.get(i);
				cnt++;
			}
		}
		return toReturn;
	}



	@Override
	public Refrigerator[] getAllRefrigerators() {
		int cnt = 0;
		for (int i = 0; i < size; i++)
		{
			if (list.get(i) instanceof TV)
			{
				cnt++;
			}
		}
		Refrigerator[] toReturn = new Refrigerator[cnt];
		cnt = 0;
		for (int i = 0; i < size; i++)
		{
			if (list.get(i) instanceof Refrigerator)
			{
				toReturn[cnt] = (Refrigerator) list.get(i);
				cnt++;
			}
		}
		return toReturn;	
	}

	@Override
	public void delete(int pid) {
		for (Iterator<Product> it = list.iterator(); it.hasNext();)
		{
			Product p = it.next();
			if (p.getPid() == pid)
			{
				it.remove();
			}
		}

	}

	@Override
	public long totalPrice() {
		long total = 0;
		for (Product p : list)
		{
			total += p.getPrice();
		}
		return total;
	}

	@Override
	public void makeReport() {
		new Thread() {
			public void run()
			{
				try (PrintWriter pw = new PrintWriter(new FileWriter("./product.dat",true),false))
				{
					for (Product p : list)
					{
						pw.println(p);
					}
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}.start();
	}

	@Override
	public void sendToServer() {
		new Thread()
		{
			public void run()
			{
				try (Socket s = new Socket("localhost", 8080);
						PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));)
				{
					StringBuilder sb = new StringBuilder();
					for (Product p : list)
					{
						if (p instanceof TV)
						{
							pw.println(p);
						}
						else if (p instanceof Refrigerator)
						{
							sb.append(p + "\n");
						}
					}
					pw.println(sb.toString());
					pw.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}.start();
	}
	


}
