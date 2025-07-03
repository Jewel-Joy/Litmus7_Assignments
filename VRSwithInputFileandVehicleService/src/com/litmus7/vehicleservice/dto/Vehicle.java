package com.litmus7.vehicleservice.dto;


	/**
	 * This class contains brand,model and rent/day of vehicle.
	 */

public class Vehicle {
	private String brand;
	private String model;
	private double rentalPricePerDay;
	
	/**
	 * default constructor that initializes the data with default values
	 */
	
	public Vehicle() {
		setBrand("");
		setModel("");
		setRentalPricePerDay(0);
	}
	
	/**
	 * Parameterized constructor that initializes the data  .
	 * @param brand is a string
	 * @param model is a string
	 * @param rentalPricePerDay is a double
	*/
	
	public Vehicle(String brand,String model,double rentalPricePerDay) {
		this.setBrand(brand);
		this.setModel(model);
		this.setRentalPricePerDay(rentalPricePerDay);
	}
	/*
	 * toString() converts object to String
	 */
	
	public String toString() {
	    return "Brand: " + getBrand() + "\nModel: " + getModel() + "\nRent per day: " + getRentalPricePerDay();
	}
	
	public String displayDetails() {
	    return this.toString(); 
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getRentalPricePerDay() {
		return rentalPricePerDay;
	}

	public void setRentalPricePerDay(double rentalPricePerDay) {
		this.rentalPricePerDay = rentalPricePerDay;
	}


	

}
