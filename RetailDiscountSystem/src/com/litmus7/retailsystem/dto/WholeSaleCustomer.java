package com.litmus7.retailsystem.dto;
	/*
	 * class WholeSale Customer implements Discountable
	 */
public class WholeSaleCustomer implements Discountable{
	private double discount=0;
	/*
	 * @param totalAmount is Double
	 */
	public double applyDiscount(double totalAmount) {
		if(totalAmount>10000)
		discount=(15*totalAmount)/100;
		else
		discount=(10*totalAmount)/100;
		System.out.println("The discount applied is: "+discount);
		return totalAmount-discount;
		
	}
}
