package com.litmus7.retailsystem.dto;
	/*
	 * class RegularCustomer implements Discountable
	 */
	public class RegularCustomer implements Discountable{
	private double discount=0;
	/*
	 * @param totalAmount is Double
	 */
	public double applyDiscount(double totalAmount) {
		discount=(5*totalAmount)/100;
		System.out.println("The discount applied is: "+discount);
		return totalAmount-discount;
	}
}
