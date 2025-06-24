package com.litmus7.vehicleservice.dto;
import java.util.Scanner;

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
	 * This method accepts the value of data of the vehicle
	 */
	
	public void inputDetails() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the brand");
		brand=scanner.nextLine();
		System.out.println("Enter the model");
		model=scanner.nextLine();
		System.out.println("Enter the rent price per day");
		rentalPricePerDay=scanner.nextDouble();
		
	}
	
	/*
	 * This method accepts the value of data of the vehicle
	 */
	
	public void displayDetails() {
		System.out.println("Brand : "+brand);
		System.out.println("Model : "+model);
		System.out.println("Rent per day : " +rentalPricePerDay);
	}
}
