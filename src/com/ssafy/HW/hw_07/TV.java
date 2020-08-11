package com.ssafy.HW.hw_07;


public class TV extends Product {
	private int size;
	
	public TV(int pid, String name, double price, int stock, int size) {
		super(pid, name, price, stock);
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
