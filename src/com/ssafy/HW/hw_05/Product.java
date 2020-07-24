package com.ssafy.HW.hw_05;

public class Product {
	private int pid;
	private String name;
	private float price;
	private int quantity;
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product(int pid, String name, float price, int quantity) {
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	

}
