package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.OrderDao;
import com.dao.OrderDaoImpl;
import com.model.OrderDetail;

public class OrderService {
	OrderDao dao = new OrderDaoImpl();
	
	public List<OrderDetail> findAll() throws SQLException {
		
		return dao.findAll();
	}

	public int calculateTotalAmount(int orderId) throws SQLException {
		int quantity = dao.getQuantity(orderId);
		int price = dao.getPrice(orderId);
		int totalAmount = price*quantity;
		return totalAmount;
	}

	public OrderDetail getOrderDetail(int orderId1) throws SQLException {
		return dao.getOrderDetail(orderId1);
	}

	public int updateOrderStatus(int orderId2) throws SQLException {
		return dao.updateOrderStatus(orderId2);
	}

	public int cancelOrder(int orderId3, String status2) throws SQLException {
		dao.cancelOrder(orderId3, status2);
		return dao.getQuantity(orderId3);
	}

	public double calculateSubtotal(int orderId4) throws SQLException {
		int quantity = dao.getQuantity(orderId4);
		int price = dao.getPrice(orderId4);
		int discount = dao.getDiscount(orderId4);
		int totalAmount = price*quantity;
		totalAmount = totalAmount*(100 - discount)/100;
		return totalAmount ;
	}

	public int updateQuantity(int orderId5, int quantity) throws SQLException {
		return dao.updateQuantity(orderId5,quantity);
	}

	public int addDiscount(int orderId6,int discount) throws SQLException {
		
		return dao.addDiscount(orderId6,discount);
	}

}
