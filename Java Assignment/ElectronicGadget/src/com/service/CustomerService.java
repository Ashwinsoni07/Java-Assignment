package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.exception.InvalidCredentialException;
import com.model.Customer;

public class CustomerService {
	CustomerDao dao = new CustomerDaoImpl();
	
	public List<Customer> findAll() throws SQLException {
		
		return dao.findAll();
	}

	public int calculateTotalOrders(int customerId) throws InvalidCredentialException, SQLException {
		boolean status = dao.findOne(customerId);
		if(!status) {
			throw new InvalidCredentialException("Invalid customerId");
		}
		return dao.calculateTotalOrders(customerId);
	}

	public int updateCustomer(int customerId, Customer customer) throws InvalidCredentialException, SQLException{
		boolean status = dao.findOne(customerId);
		if(!status) {
			throw new InvalidCredentialException("Invalid customerId");
		}
		return dao.updateCustomerInfo(customerId,customer);
	}

	public Customer getCustomerDetail(int customerId) throws InvalidCredentialException, SQLException {
		boolean status = dao.findOne(customerId);
		if(!status) {
			throw new InvalidCredentialException("Invalid customerId");
		}
		return dao.getCustomerDetail(customerId);
	}

}
