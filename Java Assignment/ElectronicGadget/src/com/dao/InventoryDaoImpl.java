package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Inventory;
import com.model.Product;
import com.utility.DBConnection;

public class InventoryDaoImpl implements InventoryDao {

	@Override
	public int updateStockQuantity(int productId, int quantity) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE inventory SET quantity_in_stock = ? WHERE product_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, quantity);
		pstmt.setInt(2, productId);

		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;

	}

	@Override
	public List<Product> listLowStockProduct() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT p.* FROM product p JOIN inventory i ON p.product_id = i.product_id WHERE i.quantity_in_stock < ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, 5);
		ResultSet rst = pstmt.executeQuery();
		List<Product> list = new ArrayList<>();
		while (rst.next()) {
			int productId = rst.getInt("product_id");
			String name = rst.getString("product_name");
			String description = rst.getString("product_description");
			int price = rst.getInt("price");

			Product product = new Product(productId, name, description, price);
			list.add(product);

		}
		DBConnection.dbClose();
		return list;

	}

	@Override
	public int getInventoryValue(int productId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT (p.price*i.quantity_in_stock) as 'total_value' FROM product p "
				+ "JOIN inventory i ON p.product_id = i.product_id WHERE p.product_id = ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, productId);
		ResultSet rst = pstmt.executeQuery();
		int value = 0;
		if (rst.next()) {
			value = rst.getInt("total_value");
		}
		DBConnection.dbClose();
		return value;

	}

	@Override
	public List<Inventory> findAll() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM inventory ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		List<Inventory> list = new ArrayList<>();
		while (rst.next()) {
			int inventoryId = rst.getInt("inventory_id");
			int productId = rst.getInt("product_id");
			int quantityInStock = rst.getInt("quantity_in_stock");
			String updateDate = rst.getString("last_stock_update");

			Inventory inventory = new Inventory(inventoryId, productId, quantityInStock, updateDate);
			list.add(inventory);

		}
		DBConnection.dbClose();
		return list;

	}

	@Override
	public boolean checkProductAvailability(int productId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT p.* FROM product p JOIN inventory i ON p.product_id = i.product_id WHERE p.product_id = ? AND i.quantity_in_stock > ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, productId);
		pstmt.setInt(2, 0);
		ResultSet rst = pstmt.executeQuery();
		boolean status = rst.next();

		DBConnection.dbClose();

		return status;
	}

	@Override
	public int getQuantityInStock(int productId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT i.quantity_in_stock FROM product p " + "JOIN inventory i ON p.product_id = i.product_id "
				+ "WHERE p.product_id = ? AND i.quantity_in_stock > ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, productId);
		pstmt.setInt(2, 0);
		ResultSet rst = pstmt.executeQuery();
		int quantity = 0;

		if (rst.next()) {
			quantity = rst.getInt("quantity_in_stock");
		}

		DBConnection.dbClose();
		return quantity;
	}

	@Override
	public Product getProduct(int productId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT p.* FROM product p " + "JOIN inventory i ON p.product_id = i.product_id "
				+ "WHERE p.product_id = ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, productId);
		ResultSet rst = pstmt.executeQuery();

		if (rst.next()) {
			String name = rst.getString("product_name");
			String description = rst.getString("product_description");
			int price = rst.getInt("price");
			Product product = new Product(productId, name, description, price);
			DBConnection.dbClose();
			return product;
		}
		DBConnection.dbClose();
		return null;
	}

	@Override
	public List<Product> listOutOfStockProduct() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT p.* FROM product p JOIN inventory i ON p.product_id = i.product_id WHERE i.quantity_in_stock = ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, 0);
		ResultSet rst = pstmt.executeQuery();
		List<Product> list = new ArrayList<>();
		while (rst.next()) {
			int productId = rst.getInt("product_id");
			String name = rst.getString("product_name");
			String description = rst.getString("product_description");
			int price = rst.getInt("price");

			Product product = new Product(productId, name, description, price);
			list.add(product);

		}
		
		DBConnection.dbClose();
		return list;

	}

}
