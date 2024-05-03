package com.model;

public class OrderDetail {
	private int orderDetailId;
	private int orderId;
	private int productId;
	private int quantity;
	private String status;
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(int orderDetailId, int orderId, int productId, int quantity, String status) {
		super();
		this.orderDetailId = orderDetailId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.status = status;
	}
	@Override
	public String toString() {
		return "OrderDetail [orderDetailId=" + orderDetailId + ", orderId=" + orderId + ", productId=" + productId
				+ ", quantity=" + quantity + ", status=" + status + "]";
	}
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
