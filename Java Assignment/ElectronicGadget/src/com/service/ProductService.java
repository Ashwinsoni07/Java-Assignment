package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.ProductDao;
import com.dao.ProductDaoImpl;
import com.exception.InvalidCredentialException;
import com.model.Product;

public class ProductService {
	ProductDao dao = new ProductDaoImpl();
	public List<Product> findAll() throws SQLException {
		
		return dao.findAll();
	}

	public int updateProductDetail(int productId, int price, String description) throws InvalidCredentialException, SQLException {
		boolean status = dao.findOne(productId);
		if(!status) {
			throw new InvalidCredentialException("Invalid customerId");
		}
		return dao.updateProductDetail(productId,price,description);
	}

	public int isProductInStock(int productId) throws InvalidCredentialException, SQLException {
		boolean status = dao.findOne(productId);
		if(!status) {
			throw new InvalidCredentialException("Invalid customerId");
		}
		return dao.isProductInStock(productId);
	}

	public Product getProductDetail(int productId) throws InvalidCredentialException, SQLException {
		boolean status = dao.findOne(productId);
		if(!status) {
			throw new InvalidCredentialException("Invalid customerId");
		}
		return dao.getProductDetail(productId);
	}

}
