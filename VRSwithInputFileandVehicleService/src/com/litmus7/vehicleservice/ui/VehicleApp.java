package com.litmus7.vehicleservice.ui;
import java.util.Scanner;

import com.litmus7.vehicleservice.controller.VehicleController;
import com.litmus7.vehicleservice.dto.Bike;
import com.litmus7.vehicleservice.dto.Car;


public class VehicleApp {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		VehicleController controller=new VehicleController();
		String result=controller.loadVehicles();
		System.out.println(result);
		
		System.out.println("-----The vehicles in the list------");
		controller.displayAllVehicleDetails();
		
		/*
		 * To add new vehicle
		 */
		System.out.println("Do you want to add vehicle to the list \n 1:yes \n 2:no");
		int choice1=scanner.nextInt();
		if(choice1==1) {
			System.out.println("What to add \n 1:Car \n 2:Bike");
			int choice2=scanner.nextInt();
			if(choice2==1) {
				
				System.out.println("----Enter the car details----");
				System.out.println("Enter the brand");
				String brand=scanner.next();
				System.out.println("Enter the model");
				String model=scanner.next();
				System.out.println("Enter the rent price per day");
				double rentalPricePerDay=scanner.nextDouble();
				System.out.println("Enter the number of doors");
				int numberOfDoors=scanner.nextInt();
				System.out.println("Is the car automatic");
				boolean isAutomatic=scanner.nextBoolean();
				Car car=new Car(brand,model,rentalPricePerDay,numberOfDoors,isAutomatic);
				
				System.out.println(controller.addVehicles(car));
			}else {
				System.out.println("Enter the brand");
				String brand=scanner.next();
				System.out.println("Enter the model");
				String model=scanner.next();
				System.out.println("Enter the rent price per day");
				double rentalPricePerDay=scanner.nextDouble();
				System.out.println("Enter the engine capacity");
				int engineCapacity=scanner.nextInt();
				System.out.println("Does the bike has gears");
				boolean hasGears=scanner.nextBoolean();
				Bike bike=new Bike(brand,model,rentalPricePerDay,engineCapacity,hasGears);
				
				System.out.println(controller.addVehicles(bike));
			}
		}
		else {
			System.out.println("Not required to add vehicle.");
		}
		/*
		 * to search for a vehicle
		 */
		System.out.println("Do you want to search any vehicle \n 1:Yes \n 2:No");
		int choice3=scanner.nextInt();
		if(choice3==1) {
			System.out.println("Enter the brand and model");
			String brand=scanner.next();
			
			String model=scanner.next();
		
			result =controller.vehicleSearch(brand, model);
			System.out.println(result);
		}
		/*
		 * To print the total rent
		 */
		
		System.out.println("The total rent of all vehicle is: "+controller.totalRent());
		

	}

}
