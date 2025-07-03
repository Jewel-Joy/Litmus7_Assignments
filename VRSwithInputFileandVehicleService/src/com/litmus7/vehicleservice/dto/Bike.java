package com.litmus7.vehicleservice.dto;


	/*
	 * This class inherits properties from the Vehicle class
	 */

public class Bike extends Vehicle {
	private boolean hasGears;
	private int engineCapacity;
	/*
	 * default constructor initializes engine capacity and 
	 * does the bike has gears
	 */
	public Bike(){
		engineCapacity=125;
		hasGears=true;
	}
	
	/**
	 * This is a parameterized constructor.
	 * @param brand is a string
	 * @param model is a string
	 * @param rentalPricePerDayis a double
	 * @param engineCapacityis an integer
	 * @param hasGear is a boolean
	 * 
	 */
	
	public Bike(String brand,String model,double rentalPricePerDay,int engineCapacity,boolean hasGears) {
		super(brand,model,rentalPricePerDay);
		this.engineCapacity=engineCapacity;
		this.hasGears=hasGears;
		
	}
	
	/*
	 * toString() converts object to string
	 */
	

	public String toString() {
		return "Brand "+getBrand()+"\nModel "+getModel()+"\nRentPerDay "+getRentalPricePerDay()+"\nEngine Capacity "+engineCapacity+"\nHas gears  "+hasGears;
	}

	

	
	public String displayDetails() {
		System.out.println("----Displaying the bike details----\n");
		return this.toString();
				
	}
}
