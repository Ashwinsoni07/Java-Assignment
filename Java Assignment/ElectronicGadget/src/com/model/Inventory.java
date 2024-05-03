package com.model;

public class Inventory {
	int inventoryId;
	int productId;
	int quantityInStock;
	String lastStockUpdate;
	public int getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public String getLastStockUpdate() {
		return lastStockUpdate;
	}
	public void setLastStockUpdate(String lastStockUpdate) {
		this.lastStockUpdate = lastStockUpdate;
	}
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inventory(int inventoryId, int productId, int quantityInStock, String lastStockUpdate) {
		super();
		this.inventoryId = inventoryId;
		this.productId = productId;
		this.quantityInStock = quantityInStock;
		this.lastStockUpdate = lastStockUpdate;
	}
	@Override
	public String toString() {
		return "InventoryModel [inventoryId=" + inventoryId + ", productId=" + productId + ", quantityInStock="
				+ quantityInStock + ", lastStockUpdate=" + lastStockUpdate + "]";
	}
	
	
}
