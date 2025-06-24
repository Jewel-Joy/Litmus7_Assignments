package com.litmus7.vehicleservice.dto;
import java.util.Scanner;

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
	 * this method calls the inputDetails() method of the parent class and also accepts
	 * the value of engine capacity and does the bike has gears
	 */
	
	public void inputDetails() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("----Enter the bike details----");
		super.inputDetails();
		System.out.println("Enter the engine capacity");
		engineCapacity=scanner.nextInt();
		System.out.println("Does the bike has gears");
		hasGears=scanner.nextBoolean();
	}
	
	/*
	 * this method calls the displayDetails() method of the parent class and also
	 * displays the value of engine capacity and does the bike has gears
	 */
	
	public void displayDetails() {
		System.out.println("----Displaying the bike details----");
		super.displayDetails();
		System.out.println("Engine Capacity : "+engineCapacity);
		System.out.println("Does the bike has gears : "+hasGears);
	}
}
