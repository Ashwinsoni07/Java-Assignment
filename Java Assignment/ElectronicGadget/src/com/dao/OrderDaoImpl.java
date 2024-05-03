package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Order;
import com.model.OrderDetail;
import com.model.Product;
import com.utility.DBConnection;

public class OrderDaoImpl implements OrderDao {

	@Override
	public int addDiscount(int orderId6, int discount) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE orderdetail SET discount = ? WHERE order_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, discount);
		pstmt.setInt(2, orderId6);
		
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

	@Override
	public int updateQuantity(int orderId5, int quantity) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE orderdetail SET quantity = ? WHERE order_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, quantity);
		pstmt.setInt(2, orderId5);
		
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

	@Override
	public int getDiscount(int orderId4) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT discount FROM orderdetail WHERE order_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, orderId4);
		ResultSet rst = pstmt.executeQuery();
		int discount = 0;
		if(rst.next()) {
			discount = rst.getInt("discount");
		}
		DBConnection.dbClose();
		return discount;
	}

	@Override
	public int getPrice(int orderId4) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT p.price FROM orderdetail o "
				+ "JOIN product p ON o.product_id = p.product_id "
				+ "WHERE o.order_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, orderId4);
		ResultSet rst = pstmt.executeQuery();
		int price = 0;
		if(rst.next()) {
			price = rst.getInt("price");
		}
		DBConnection.dbClose();
		return price;
	}

	@Override
	public int getQuantity(int orderId4) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT quantity FROM orderdetail WHERE order_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, orderId4);
		ResultSet rst = pstmt.executeQuery();
		int quantity = 0;
		if(rst.next()) {
			quantity = rst.getInt("quantity");
		}
		DBConnection.dbClose();
		return quantity;
	}

	@Override
	public void cancelOrder(int orderId3, String status2) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE orderdetail SET status = ? WHERE order_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "cancelled");
		pstmt.setInt(2, orderId3);
		
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		

	}

	@Override
	public int updateOrderStatus(int orderId2) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE orderdetail SET status = ? WHERE order_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "shipped");
		pstmt.setInt(2, orderId2);
		
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

	@Override
	public OrderDetail getOrderDetail(int orderId1) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM orderdetail WHERE order_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, orderId1);
		ResultSet rst = pstmt.executeQuery();
		if(rst.next()) {
			int orderDetailId = rst.getInt("order_detail_id");
			int orderId = rst.getInt("order_id");
			int productId = rst.getInt("product_id");
			int quantity = rst.getInt("quantity");
			String status = rst.getString("status");

			OrderDetail order = new OrderDetail(orderDetailId,orderId,productId,quantity,status);
			
			return order;
		}
		DBConnection.dbClose();
		return null;
	}

	@Override
	public List<OrderDetail> findAll() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM orderdetail ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<OrderDetail> list = new ArrayList<>();
		while (rst.next()) {
			int orderDetailId = rst.getInt("order_detail_id");
			int orderId = rst.getInt("order_id");
			int productId = rst.getInt("product_id");
			int quantity = rst.getInt("quantity");
			String status = rst.getString("status");

			OrderDetail order = new OrderDetail(orderDetailId,orderId,productId,quantity,status);
			list.add(order);

		}
		DBConnection.dbClose();
		return list;
	}
	

}
