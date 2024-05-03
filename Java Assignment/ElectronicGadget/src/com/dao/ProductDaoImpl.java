package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;
import com.utility.DBConnection;

public class ProductDaoImpl implements ProductDao {

	@Override
	public boolean findOne(int productId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM product WHERE product_id = ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, productId);
		ResultSet rst = pstmt.executeQuery();
		boolean status = rst.next();

		DBConnection.dbClose();
		return status;
	}

	@Override
	public List<Product> findAll() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM product ";
		PreparedStatement pstmt = con.prepareStatement(sql);
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
	public int isProductInStock(int productId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT i.quantity_in_stock FROM product p JOIN inventory i ON p.product_id = i.product_id WHERE p.product_id = ? AND i.quantity_in_stock > ?";
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
	public Product getProductDetail(int productId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM product WHERE product_id = ? ";
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
	public int updateProductDetail(int productId, int price, String description) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "UPDATE product SET product_description = ?, product_price = ? WHERE product_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, description);
		pstmt.setInt(2, price);
		pstmt.setInt(3, productId);
		int status = pstmt.executeUpdate();

		DBConnection.dbClose();
		return status;
	}

}
