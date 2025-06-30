package com.litmus7.vehicleservice.dto;


	/*
	 * This class inherits properties from the Vehicle class
	 */

public class Car extends Vehicle {
	private int numberOfDoors;
	private boolean isAutomatic;
	
	/*
	 * default constructor initializes the number of doors and isAutomatic
	 */
	
	public Car(){
		numberOfDoors=4;
		isAutomatic=false;
	}
	
	/**
	 *This is a parameterized constructor.
	 * @param brand is a string
	 * @param model is a string
	 * @param rentalPricePerDay is a double
	 * @param numberOfDoors is an integer
	 * @param isAutomatic is a boolean
	 */
	
	public Car(String brand,String model,double rentalPricePerDay,int numberOfDoors,boolean isAutomatic) {
		super(brand,model,rentalPricePerDay);
		this.numberOfDoors=numberOfDoors;
		this.isAutomatic=isAutomatic;
		
	}

	
	/*
	 * toString() converts object to string
	 */
	public String toString() {
		return "Brand "+brand+"\nModel "+model+"\nRentPerDay "+rentalPricePerDay+"\nNumber of doors "+numberOfDoors+"\nIit Automatic "+isAutomatic;
	}
	
	public String displayDetails() {
		System.out.println("----Displaying the car details----\n");
		return this.toString();
	}
}
