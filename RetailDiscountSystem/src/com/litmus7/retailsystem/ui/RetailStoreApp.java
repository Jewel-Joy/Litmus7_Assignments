package com.litmus7.retailsystem.ui;
import java.util.Scanner;

import com.litmus7.retailsystem.controller.RetailSystemController;

public class RetailStoreApp {

	public static void main(String[] args) {
		RetailSystemController controller=new RetailSystemController();
		int customerType=0;
		double totalAmount=0;
		double payableAmount=0;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter customer type (1- Regular, 2- Premium, 3- Wholesale): ");
		customerType=scanner.nextInt();
		System.out.println("Enter total purchase amount: ");
		totalAmount=scanner.nextDouble();
		switch(customerType) {
		case 1:
			System.out.println("Customer Type:Regular Customer");
			System.out.println("Original Amount: "+totalAmount);
			payableAmount=controller.regularCustomer(totalAmount);
			System.out.println("Final Payable Amount: "+payableAmount);
			break;
		case 2:
			System.out.println("Customer Type:Preminum Customer");
			System.out.println("Original Amount: "+totalAmount);
			payableAmount=controller.premiumCustomer(totalAmount);
			System.out.println("Final Payable Amount: "+payableAmount);
			break;
		case 3:
			System.out.println("Customer Type:WholeSale Customer");
			System.out.println("Original Amount: "+totalAmount);
			payableAmount=controller.wholesaleCustomer(totalAmount);
			System.out.println("Final Payable Amount: "+payableAmount);
			break;
		default:
			System.out.println("No matching case");
			
			
		}

	}

}
