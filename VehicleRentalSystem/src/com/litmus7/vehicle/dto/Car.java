package com.litmus7.vehicle.dto;
import java.util.Scanner;

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
	 * this method calls the inputDetails() method of the parent class and also accepts
	 * the value of number of doors and is the car automatic
	 */
	
	public void inputDetails() {
		Scanner scanner=new Scanner(System.in);		System.out.println("----Enter the car details----");
		super.inputDetails();
		System.out.println("Enter the number of doors");
		numberOfDoors=scanner.nextInt();
		System.out.println("Is the car automatic");
		isAutomatic=scanner.nextBoolean();
	}
	
	/*
	 * this method calls the displayDetails() method of the parent class and also
	 * displays the value of number of doors and is the car automatic
	 */
	
	public void displayDetails() {
		System.out.println("----Displaying the car details----");
		super.displayDetails();
		System.out.println("Number of Doors : "+numberOfDoors);
		System.out.println("Is the car automatic : "+isAutomatic);
	}
}
