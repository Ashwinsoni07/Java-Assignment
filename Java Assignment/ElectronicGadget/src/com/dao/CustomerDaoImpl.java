package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Customer;
import com.utility.DBConnection;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public int calculateTotalOrders(int customerId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM customer c JOIN ordertable o ON c.customer_id = o.customer_id"
				+"GROUP BY o.customer_id HAVING c.customer_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, customerId);
		return 0;
	}

	@Override
	public Customer getCustomerDetail(int customerId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM customer WHERE customer_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, customerId);
		ResultSet rst = pstmt.executeQuery();
		Customer customer = new Customer();
		if(rst.next()==true) {
			customer.getCustomerId();
			customer.getFirstName();
			customer.getLastName();
			customer.getPhoneNumber();
			customer.getEmail();
			customer.getAddress();
			
		}
		return customer;
	}

	@Override
	public int updateCustomerInfo(int customerId,Customer customer) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE customer SET first_name = ? , last_name = ?, email = ?, phone_number = ?, address = ? WHERE customer_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, customer.getFirstName());
		pstmt.setString(2, customer.getLastName());
		pstmt.setString(3, customer.getEmail());
		pstmt.setString(4, customer.getPhoneNumber());
		pstmt.setString(5, customer.getAddress());
		pstmt.setInt(6, customerId);
		
		int status = pstmt.executeUpdate();

		DBConnection.dbClose();
		return status;
	}

	@Override
	public List<Customer> findAll() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM customer ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Customer>list = new ArrayList<>();
		while(rst.next()) {
			int customerId = rst.getInt("customer_id");
			String firstName = rst.getString("first_name");
			String lastName = rst.getString("last_name");
			String phoneNumber = rst.getString("phone_number");
			String email = rst.getString("email");
			String address = rst.getString("address");
			
			Customer customer = new Customer(customerId,firstName,lastName,phoneNumber,email,address);
			list.add(customer);
		}
		DBConnection.dbClose();
		return list;
	}


	@Override
	public boolean findOne(int customerId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM customer WHERE customer_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, customerId);
		ResultSet rst = pstmt.executeQuery();
		if(rst.next()) {
			return true;
		}
		return false;
	}

}
