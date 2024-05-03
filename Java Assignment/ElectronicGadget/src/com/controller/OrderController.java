package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.OrderDetail;
import com.service.InventoryService;
import com.service.OrderService;

public class OrderController {

	public static void main(String[] args) {
		OrderService orderService = new OrderService();
		InventoryService inventoryService = new InventoryService();
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------WELCOME-----------");
		while (true) {
			System.out.println("Press 1 to Calculate Total Amount");
			System.out.println("Press 2 to Get Order Details");
			System.out.println("Press 3 to Update Order Status");
			System.out.println("Press 4 to Cancel Order");
			System.out.println("Press 5 to Calculate Subtotal");
			System.out.println("Press 6 to Update Ouantity");
			System.out.println("Press 7 to Add Discount");
			System.out.println("Press 0 to Exit");

			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting...");
				break;
			}
			switch (input) {
			case 1:
				try {
					System.out.println("Select orderId from the list to calculate total amount");
					List<OrderDetail> list = orderService.findAll();
					for (OrderDetail p : list) {
						System.out.println(p);
					}
					System.out.println("Enter orderId ");
					int orderId = sc.nextInt();

					int amount = orderService.calculateTotalAmount(orderId);

					System.out.println("Total Amount is : " + amount);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2:
				try {
					System.out.println("Select orderId from the list to get order detail");
					List<OrderDetail> list1 = orderService.findAll();
					for (OrderDetail p : list1) {
						System.out.println(p);
					}
					System.out.println("Enter orderId ");
					int orderId1 = sc.nextInt();

					OrderDetail order = orderService.getOrderDetail(orderId1);
					System.out.println(order);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				try {
					System.out.println("Select orderId from the list to update order status");
					List<OrderDetail> list2 = orderService.findAll();
					for (OrderDetail p : list2) {
						System.out.println(p);
					}
					System.out.println("Enter orderId ");
					int orderId2 = sc.nextInt();

					int status = orderService.updateOrderStatus(orderId2);

					if (status != 0) {
						System.out.println("Order Status Updated!");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				break;

			case 4:
				try {
					System.out.println("Select orderId and productId from the list to cancel order");
					List<OrderDetail> list3 = orderService.findAll();
					for (OrderDetail p : list3) {
						System.out.println(p);
					}
					System.out.println("Enter orderId ");
					int orderId3 = sc.nextInt();
					System.out.println("Enter productId ");
					int productId = sc.nextInt();

					String status2 = "Cancel";
					int quantity = orderService.cancelOrder(orderId3, status2);
					int newStatus = inventoryService.updateStockQuantity(productId, quantity);
					if (newStatus != 0) {
						System.out.println("Order Status Updated!");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 5:
				try {
					System.out.println("Select orderId from the list to Calculate Subtotal");
					List<OrderDetail> list4 = orderService.findAll();
					for (OrderDetail p : list4) {
						System.out.println(p);
					}
					System.out.println("Enter orderId ");
					int orderId4 = sc.nextInt();

					double subtotal = orderService.calculateSubtotal(orderId4);

					System.out.println("The Subtotal of order is: " + subtotal);

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				break;

			case 6:
				try {
					System.out.println("Select orderId from the list to Update quantity");
					List<OrderDetail> list5 = orderService.findAll();
					for (OrderDetail p : list5) {
						System.out.println(p);
					}
					System.out.println("Enter orderId ");
					int orderId5 = sc.nextInt();
					System.out.println("Enter quantity ");
					int quantity1 = sc.nextInt();

					int quantityStatus = orderService.updateQuantity(orderId5, quantity1);

					if (quantityStatus != 0) {
						System.out.println("Quantity Updated!");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				break;

			case 7:
				try {
					System.out.println("Select orderId from the list to Add discount");
					List<OrderDetail> list6 = orderService.findAll();
					for (OrderDetail p : list6) {
						System.out.println(p);
					}
					System.out.println("Enter orderId ");
					int orderId6 = sc.nextInt();

					System.out.println("Enter Discount Percent ");
					int discount = sc.nextInt();

					int status3 = orderService.addDiscount(orderId6, discount);

					if (status3 != 0) {
						System.out.println("Discount Added!");
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
