package com.litmus7.vehicle;

import com.litmus7.vehicle.dto.Bike;
import com.litmus7.vehicle.dto.Car;
import java.util.Scanner;
public class VehicleApp {

	public static void main(String[] args) {
/*
 * Default constructor
 * */
     System.out.println("----Default Constructor----");
		Car cars=new Car();
		cars.inputDetails();
		cars.displayDetails();
		Bike bikes=new Bike();
		bikes.inputDetails();
		bikes.displayDetails();
		
/*
 * Parameterized Constructor
 */ 	
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("----Parameterized Constructor----");
		
 		System.out.println("----Enter the car details----");
 		
 		System.out.println("Enter the brand");
 		String brand=scanner.nextLine();
 		System.out.println("Enter the model");
 		String model=scanner.nextLine();
 		System.out.println("Enter the rent per day");
 		double rentPricePerDay=scanner.nextDouble();
 		System.out.println("Enter the number of doors");
 		int numberOfDoors=scanner.nextInt();
 		System.out.println("Enter the is the car automatic");
 		boolean isAutomatic=scanner.nextBoolean();
 		scanner.nextLine();
 		
		Car parameterizedcars=new Car(brand,model,rentPricePerDay,numberOfDoors,isAutomatic);
		System.out.println("Parameterized Bike details");
		parameterizedcars.displayDetails();
		
 		System.out.println("----Enter the bike details----");
 		
 		System.out.println("Enter the brand");
 		brand=scanner.nextLine();
 		System.out.println("Enter the model");
 		model=scanner.nextLine();
 		System.out.println("Enter the rent per day");
 		rentPricePerDay=scanner.nextDouble();
 		System.out.println("Enter the engine capacity");
 		int engineCapacity=scanner.nextInt();
 		System.out.println("Enter does the bike has gears");
 		boolean hasGears=scanner.nextBoolean();
 		
		Bike parameterizedbikes=new Bike(brand,model,rentPricePerDay,engineCapacity,hasGears);
		System.out.println("Parameterized bike details");
		parameterizedbikes.displayDetails();
		
	}

}
