package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Customer;

public interface CustomerDao {
	
	Customer getCustomerDetail(int customerId) throws SQLException;
	int updateCustomerInfo(int customerId, Customer customer) throws SQLException;
	List<Customer> findAll() throws SQLException;
	boolean findOne(int customerId) throws SQLException;
	int calculateTotalOrders(int customerId) throws SQLException;
	
}
