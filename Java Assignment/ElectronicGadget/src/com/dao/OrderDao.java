package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Order;
import com.model.OrderDetail;

public interface OrderDao {

	int addDiscount(int orderId6, int discount) throws SQLException;
	
	int updateQuantity(int orderId5, int quantity) throws SQLException;
	
	int getDiscount(int orderId4) throws SQLException;
	
	int getPrice(int orderId4) throws SQLException;
	
	int getQuantity(int orderId4) throws SQLException;
	
	void cancelOrder(int orderId3, String status2) throws SQLException;
	
	int updateOrderStatus(int orderId2) throws SQLException;
	
	OrderDetail getOrderDetail(int orderId1) throws SQLException;
	
	List<OrderDetail> findAll() throws SQLException;
	
}
