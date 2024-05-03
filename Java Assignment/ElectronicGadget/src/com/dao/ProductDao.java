package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Product;

public interface ProductDao {

	boolean findOne(int productId) throws SQLException;

	List<Product> findAll() throws SQLException;

	int isProductInStock(int productId) throws SQLException;

	Product getProductDetail(int productId) throws SQLException;

	int updateProductDetail(int productId, int price, String description) throws SQLException;

}
