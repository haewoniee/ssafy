package com.ssafy.HW.hw_04_1;

public class TV {
	private long productId;
	private String name;
	private float price;
	private int quantity;
	private float size;
	private String displayType;
	

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

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public TV(long productId, String name, float price, int quantity, float size, String displayType) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.size = size;
		this.displayType = displayType;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	@Override
	public String toString() {
		return "TV [productId=" + this.productId + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", size=" + size + ", displayType=" + displayType + "]";
	}

}
