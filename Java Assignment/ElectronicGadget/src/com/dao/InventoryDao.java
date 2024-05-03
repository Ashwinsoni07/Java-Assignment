package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Inventory;
import com.model.Product;

public interface InventoryDao {

	int updateStockQuantity(int productId, int quantity) throws SQLException ;

	List<Product> listLowStockProduct() throws SQLException ;

	int getInventoryValue(int productId) throws SQLException ;

	List<Inventory> findAll() throws SQLException ;

	boolean checkProductAvailability(int productId) throws SQLException ;

	int getQuantityInStock(int productId) throws SQLException ;

	Product getProduct(int productId) throws SQLException ;

	List<Product> listOutOfStockProduct() throws SQLException ;
	
	
	
}
