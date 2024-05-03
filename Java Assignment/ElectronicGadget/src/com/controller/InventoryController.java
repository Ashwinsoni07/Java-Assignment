package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Inventory;
import com.model.Product;
import com.service.InventoryService;

public class InventoryController {

	public static void main(String[] args) {
		// OrderService orderService = new OrderService();
		InventoryService inventoryService = new InventoryService();
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------WELCOME-----------");
		while (true) {
			System.out.println("Press 1 to Get Product");
			System.out.println("Press 2 to Get Quantity in Stock");
			System.out.println("Press 3 to Add Stock to Inventory");
			System.out.println("Press 4 to List Out of Stock Products");
			System.out.println("Press 5 to Check If Product is Available in Inventory");
			System.out.println("Press 6 to Get Inventory Value");
			System.out.println("Press 7 to List Low Stock Products");
			System.out.println("Press 0 to Exit");

			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting...");
				break;
			}
			switch (input) {

			case 1:
				try {
					System.out.println("Select productId from the list to view details");
					List<Inventory> list = inventoryService.findAll();
					for (Inventory i : list) {
						System.out.println(i);
					}
					System.out.println("Enter productId ");
					int productId = sc.nextInt();

					Product inventory = inventoryService.getProduct(productId);
					System.out.println(inventory);

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				break;

			case 2:
				try {
					System.out.println("Select productId from the list to get quantity available in stock");
					List<Inventory> list = inventoryService.findAll();
					for (Inventory i : list) {
						System.out.println(i);
					}
					System.out.println("Enter productId ");
					int productId = sc.nextInt();

					int quantity = inventoryService.getQuantityInStock(productId);
					System.out.println("Number of product available:   " + quantity);

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				try {

					System.out.println("Select productId from the list to add to stock");
					List<Inventory> list = inventoryService.findAll();
					for (Inventory i : list) {
						System.out.println(i);
					}
					System.out.println("Enter productId ");
					int productId = sc.nextInt();

					System.out.println("Enter quantity ");
					int quantity = sc.nextInt();
					int status = inventoryService.updateStockQuantity(productId, quantity);
					if (status != 0) {
						System.out.println("Stock Added!");
					}

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 4:
				try {
					List<Product> list = inventoryService.listOutOfStockProduct();
					for (Product i : list) {
						System.out.println(i);
					}

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 5:
				try {
					System.out.println("Select productId from the list to add to stock");
					List<Inventory> list = inventoryService.findAll();
					for (Inventory i : list) {
						System.out.println(i);
					}
					System.out.println("Enter productId ");
					int productId = sc.nextInt();

					boolean status = inventoryService.checkProductAvailability(productId);
					if (status) {
						System.out.println("Available!");
					} else {
						System.out.println("Not Available!");
					}

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 6:
				try {
					System.out.println("Select productId from the list to add to stock");
					List<Inventory> list = inventoryService.findAll();
					for (Inventory i : list) {
						System.out.println(i);
					}
					System.out.println("Enter productId ");
					int productId = sc.nextInt();

					int value = inventoryService.getInventoryValue(productId);
					System.out.println("Inventory Value of Product with ID: " + productId + "   is:   " + value);

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 7:
				try {
					List<Product> list = inventoryService.listLowStockProduct();
					for (Product i : list) {
						System.out.println(i);
					}

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			}
		}
		sc.close();
	}

}
