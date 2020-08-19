package com.ssafy.HW.hw_07;

public class Product {
	protected int pid;
	protected String name;
	protected double price;
	protected int stock;

	public Product(int pid, String name, double price, int stock) {
		super();
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}


	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
