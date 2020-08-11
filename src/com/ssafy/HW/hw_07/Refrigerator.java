package com.ssafy.HW.hw_07;


public class Refrigerator extends Product {
	private int volume;
	public Refrigerator(int pid, String name, double price, int stock, int volume) {
		super(pid, name, price, stock);
		this.volume = volume;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}

}
