package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.InventoryDao;
import com.dao.InventoryDaoImpl;
import com.model.Inventory;
import com.model.Product;

public class InventoryService {

	InventoryDao dao = new InventoryDaoImpl();

	public int updateStockQuantity(int productId, int quantity) throws SQLException {

		return dao.updateStockQuantity(productId, quantity);
	}

	public List<Product> listLowStockProduct() throws SQLException {

		return dao.listLowStockProduct();
	}

	public int getInventoryValue(int productId) throws SQLException {

		return dao.getInventoryValue(productId);
	}

	public List<Inventory> findAll() throws SQLException {

		return dao.findAll();
	}

	public boolean checkProductAvailability(int productId) throws SQLException {

		return dao.checkProductAvailability(productId);
	}

	public List<Product> listOutOfStockProduct() throws SQLException {

		return dao.listOutOfStockProduct();
	}

	public int getQuantityInStock(int productId) throws SQLException {

		return dao.getQuantityInStock(productId);
	}

	public Product getProduct(int productId) throws SQLException {

		return dao.getProduct(productId);
	}

}
