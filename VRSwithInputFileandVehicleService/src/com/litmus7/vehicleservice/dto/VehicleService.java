package com.litmus7.vehicleservice.dto;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
	/*
	 * VehicleService class is used to
	 * load vehicle details from the input text file
	 * to add new vehicle
	 * to display vehicle details
	 * to search for vehicle
	 * to calculate total rent
	 */
public class VehicleService {
	List<Vehicle> vehicleList=new ArrayList<>();
	/*
	 * loads the vehicle data from vehicle.txt
	 * adds the vehicles to vehicleList
	 */
	public void loadVehicles() {
		try {
			BufferedReader br=new BufferedReader(new FileReader("src/vehicle.txt"));
			String line;
			while((line=br.readLine())!=null) {
				String[] parts=line.split(",");
				if(parts[0].equalsIgnoreCase("Car")) {
					String brand=parts[1];
					String model=parts[2];
					double rentPricePerDay=Double.parseDouble(parts[3]);
					int numberOfDoors=Integer.parseInt(parts[4]);
					boolean isAutomatic=Boolean.parseBoolean(parts[5]);
					Car car=new Car(brand,model,rentPricePerDay,numberOfDoors,isAutomatic);
					vehicleList.add(car);
					
				}else {
					String brand=parts[1];
					String model=parts[2];
					double rentPricePerDay=Double.parseDouble(parts[3]);
					boolean hasGears=Boolean.parseBoolean(parts[4]);
					int engineCapacity=Integer.parseInt(parts[5]);
					Bike bike=new Bike(brand,model,rentPricePerDay,engineCapacity,hasGears);
					vehicleList.add(bike);
				}
					
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * adds new vehicle to vehicleList
	 * @param vehicle is of type Vehicle 
	 */
	public void addVehicles(Vehicle vehicle) {
		vehicleList.add(vehicle);
	}
	public void displayAllVehicleDetails() {
		for(Vehicle v:vehicleList) {
			v.displayDetails();
		}
	}
	/*
	 * search for vehicle using brand name and model name
	 * @param brand is String
	 * @param model is String
	 */
	public boolean vehicleSearch(String brand,String model) {
		for(Vehicle v:vehicleList) {
			if((v.brand).equalsIgnoreCase(brand)&&(v.model).equalsIgnoreCase(model))
				return true;
			}
		return false;
	}
	/*
	 * calculate total rent of all vehicles
	 */
	public double totalRent() {
		double total=0;
		for(Vehicle v:vehicleList) {
			total+=v.rentalPricePerDay;
			
		}
		return total;
	}
}
