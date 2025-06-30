package com.litmus7.vehicleservice.dto;


	/**
	 * This class contains brand,model and rent/day of vehicle.
	 */

public class Vehicle {
	protected String brand;
	protected String model;
	protected double rentalPricePerDay;
	
	/**
	 * default constructor that initializes the data with default values
	 */
	
	public Vehicle() {
		brand="";
		model="";
		rentalPricePerDay=0;
	}
	
	/**
	 * Parameterized constructor that initializes the data  .
	 * @param brand is a string
	 * @param model is a string
	 * @param rentalPricePerDay is a double
	*/
	
	public Vehicle(String brand,String model,double rentalPricePerDay) {
		this.brand=brand;
		this.model=model;
		this.rentalPricePerDay=rentalPricePerDay;
	}
	/*
	 * toString() converts object to String
	 */
	
	public String toString() {
	    return "Brand: " + brand + "\nModel: " + model + "\nRent per day: " + rentalPricePerDay;
	}
	
	public String displayDetails() {
	    return this.toString(); 
	}


	

}
