package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.exception.InvalidCredentialException;
import com.model.Product;
import com.service.ProductService;

public class ProductController {
	public static void main(String[] args) {
		ProductService productService = new ProductService();
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------WELCOME-----------");
		while (true) {
			System.out.println("Press 1 to Get ProductDetails");
			System.out.println("Press 2 to Update Product Info");
			System.out.println("Press 3 to Is Product In Stock");
			System.out.println("Press 0 to Exit");

			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting...");
				break;
			}

			switch (input) {
			case 1:
				try {
					System.out.println("Select a productId from the list to Product Details");
					List<Product> list = productService.findAll();
					for (Product p : list) {
						System.out.println(p);
					}
					System.out.print("Enter ProductID :");
					int productId = sc.nextInt();

					Product product;

					product = productService.getProductDetail(productId);
					System.out.println(product);
					
				} catch (InvalidCredentialException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

				break;

			case 2:
				try {
					System.out.println("Select a ProductId from the list to Update Product Info");
					List<Product> lst = productService.findAll();
					for (Product p : lst) {
						System.out.println(p);
					}
					System.out.print("Enter ProductID :");
					int productId1 = sc.nextInt();
					System.out.print("Enter Price :");
					int price = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter Description :");
					String description = sc.nextLine();

					int status = productService.updateProductDetail(productId1, price, description);
				} catch (InvalidCredentialException | SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				try {
					System.out.println("Select a ProductId to check in stock");
					List<Product> lst = productService.findAll();
					for (Product p : lst) {
						System.out.println(p);
					}
					System.out.print("Enter ProductID :");
					int productId1 = sc.nextInt();

					int inStock = productService.isProductInStock(productId1);
					if (inStock != 0) {
						System.out.println("The Product is in Stock and Quantity is:    " + inStock);
					} else {
						System.out.println("This Product is out of Stock");
					}
				} catch (InvalidCredentialException | SQLException e) {
					System.out.println(e.getMessage());
				}

				break;

			}
		}
		sc.close();
	}
}
