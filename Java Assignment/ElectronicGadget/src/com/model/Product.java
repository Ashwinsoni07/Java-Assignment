package com.model;

public class Product {
	private int productId;
	private String productName;
	private String description;
	private double price;
	
	public Product(int productId, String productName, String description, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "ProductModel [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", price=" + price + "]";
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
