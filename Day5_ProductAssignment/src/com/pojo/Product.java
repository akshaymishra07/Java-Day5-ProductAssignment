package com.pojo;

public class Product {

	
	 private int pId;
	 private String  pName;
	 private double price;
	 private int quantity;
	 private String category;
	 
	 public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int pId, String pName, double price, int quantity, String category) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", price=" + price + ", quantity=" + quantity
				+ ", category=" + category + "]";
	}
	 
	 
	
}
