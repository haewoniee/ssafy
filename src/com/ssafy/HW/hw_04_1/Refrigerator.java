package com.ssafy.hw4;

public class Refrigerator {
	private long productId;
	private String name;
	private float price;
	private int quantity;
	private float vol;


	public Refrigerator(long productId, String name, float price, int quantity, float vol) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.vol = vol;
	}


	public long getProductId() {
		return productId;
	}


	public void setProductId(long productId) {
		this.productId = productId;
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


	@Override
	public String toString() {
		return "Refrigerator [productId=" + productId + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", vol=" + vol + "]";
	}


	public float getVol() {
		return vol;
	}


	public void setVol(float vol) {
		this.vol = vol;
	}

}
