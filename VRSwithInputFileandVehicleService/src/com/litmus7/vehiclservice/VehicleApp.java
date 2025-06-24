package com.litmus7.vehiclservice;
import java.util.Scanner;

import com.litmus7.vehicleservice.dto.Bike;
import com.litmus7.vehicleservice.dto.Car;
import com.litmus7.vehicleservice.dto.VehicleService;

public class VehicleApp {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		VehicleService service=new VehicleService();
		service.loadVehicles();
		System.out.println("-----The vehicles in the list------");
		service.displayAllVehicleDetails();
		/*
		 * To add new vehicle
		 */
		System.out.println("Do you want to add vehicle to the list \n 1:yes \n 2:no");
		int choice1=scanner.nextInt();
		if(choice1==1) {
			System.out.println("What to add \n 1:Car \n 2:Bike");
			int choice2=scanner.nextInt();
			if(choice2==1) {
				Car car=new Car();
				car.inputDetails();
				service.addVehicles(car);
			}else {
				Bike bike=new Bike();
				bike.inputDetails();
				service.addVehicles(bike);
			}
			System.out.println("----The updated vehicle list----");
			service.displayAllVehicleDetails();
		}
		else {
			System.out.println("No vehicle is added");
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
		
			if(service.vehicleSearch(brand,model))
				System.out.println("Vehicle Exist");
			else
				System.out.println("Vehicle do not exist");
		}
		/*
		 * To print the total rent
		 */
		
		System.out.println("The total rent of all vehicle is: "+service.totalRent());
		

	}

}
