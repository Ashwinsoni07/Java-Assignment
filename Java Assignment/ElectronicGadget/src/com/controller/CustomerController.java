package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.exception.InvalidCredentialException;
import com.model.Customer;
import com.service.CustomerService;

public class CustomerController {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------WELCOME-----------");
		while (true) {
			System.out.println("Press 1 to View Total Orders");
			System.out.println("Press 2 to Get Customer Details");
			System.out.println("Press 3 to Update Customer Info");
			System.out.println("Press 0 to Exit");

			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Exiting...");
				break;
			}
			switch (input) {
			case 1:
				try {
					System.out.println("Select a customerId from the list to Calculate Total Orders");

					List<Customer> list = customerService.findAll();

					for (Customer c : list) {
						System.out.println(c);
					}

					System.out.print("Enter CustomerID :");
					int customerId = sc.nextInt();

					int totalOrder = customerService.calculateTotalOrders(customerId);
					System.out.println("Total number of orders : " + totalOrder);
				} catch (SQLException | InvalidCredentialException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2:
				try {
				System.out.println("Select a customerId from the list to Calculate Total Orders");

				List<Customer> list = customerService.findAll();

				for (Customer c : list) {
					System.out.println(c);
				}
				System.out.print("Enter CustomerID :");
				int customerId = sc.nextInt();
				
				Customer customer;
				
					customer = customerService.getCustomerDetail(customerId);
					System.out.println(customer);
				} catch (InvalidCredentialException | SQLException e) {
					e.printStackTrace();
				}
				
				break;

			case 3:
				try {
				System.out.println("Select a customerId from the list to Update Customer Info");
				List<Customer> lst = customerService.findAll();
				for (Customer c : lst) {
					System.out.println(c);
				}
				System.out.print("Enter CustomerID :");
				int customerId1 = sc.nextInt();

				sc.nextLine();
				System.out.println("Enter Customer First Name");
				String fname = sc.nextLine();

				System.out.println("Enter Customer lastt Name");
				String lname = sc.nextLine();
				System.out.println("Enter Customer Phone Number");
				String phone = sc.nextLine();
				System.out.println("Enter Customer Email");
				String email = sc.nextLine();
				System.out.println("Enter Customer Address");
				String address = sc.nextLine();
				

				Customer customer1 = new Customer(customerId1, fname, lname, phone, email, address);

				
					int status = customerService.updateCustomer(customerId1, customer1);
					if (status != 0)
						System.out.println("Customer Updated");
				} catch (InvalidCredentialException | SQLException e) {

					System.out.println(e.getMessage());
				}

				break;
			}

		}
			sc.close();
	}
}
