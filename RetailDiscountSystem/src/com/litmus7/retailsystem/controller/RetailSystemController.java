package com.litmus7.retailsystem.controller;
 import com.litmus7.retailsystem.dto.PremiumCustomer;
import com.litmus7.retailsystem.dto.RegularCustomer;
import com.litmus7.retailsystem.dto.WholeSaleCustomer;

public class RetailSystemController {
	
	double payableAmount=0;
	public double regularCustomer(double totalAmount) {
		RegularCustomer regular=new RegularCustomer();
		payableAmount=regular.applyDiscount(totalAmount);
		return payableAmount;
	}
	public double premiumCustomer(double totalAmount) {
		PremiumCustomer premium=new PremiumCustomer();
		payableAmount=premium.applyDiscount(totalAmount);
		return payableAmount;
		
	}
	public double wholesaleCustomer(double totalAmount) {
		WholeSaleCustomer wholesale=new WholeSaleCustomer();
		payableAmount=wholesale.applyDiscount(totalAmount);
		return payableAmount;
		
	}
	
}
