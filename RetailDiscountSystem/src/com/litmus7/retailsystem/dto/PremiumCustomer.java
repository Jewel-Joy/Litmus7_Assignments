package com.litmus7.retailsystem.dto;
	/*
	 * class Premium Customer implements Discountable
	 */
public class PremiumCustomer implements Discountable{
	private double discount=0;
	/*
	 * @param totalAmount is Double
	 */
	public double applyDiscount(double totalAmount) {
		if(totalAmount>5000)
		discount=(10*totalAmount)/100;
		else
		discount=(7*totalAmount)/100;
		System.out.println("The discount applied: "+discount);
		return totalAmount-discount;
		
	}

}
