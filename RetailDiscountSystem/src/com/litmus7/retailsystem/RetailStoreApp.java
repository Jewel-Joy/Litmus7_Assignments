package com.litmus7.retailsystem;
import java.util.Scanner;

import com.litmus7.retailsystem.dto.PremiumCustomer;
import com.litmus7.retailsystem.dto.RegularCustomer;
import com.litmus7.retailsystem.dto.WholeSaleCustomer;
public class RetailStoreApp {

	public static void main(String[] args) {
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
			RegularCustomer regular=new RegularCustomer();
			payableAmount=regular.applyDiscount(totalAmount);
			System.out.println("Final Payable Amount: "+payableAmount);
			break;
		case 2:
			System.out.println("Customer Type:Preminum Customer");
			System.out.println("Original Amount: "+totalAmount);
			PremiumCustomer premium=new PremiumCustomer();
			payableAmount=premium.applyDiscount(totalAmount);
			System.out.println("Final Payable Amount: "+payableAmount);
			break;
		case 3:
			System.out.println("Customer Type:WholeSale Customer");
			System.out.println("Original Amount: "+totalAmount);
			WholeSaleCustomer wholesale=new WholeSaleCustomer();
			payableAmount=wholesale.applyDiscount(totalAmount);
			System.out.println("Final Payable Amount: "+payableAmount);
			break;
		default:
			System.out.println("No matching case");
			
			
		}

	}

}
