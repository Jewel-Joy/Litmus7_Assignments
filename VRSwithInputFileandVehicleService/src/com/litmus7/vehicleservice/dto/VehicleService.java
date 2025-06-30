package com.litmus7.vehicleservice.dto;
import java.util.List;

import com.litmus7.vehicleservice.dataaccess.DataAccess;
import com.litmus7.vehicleservice.exception.VehicleException;
	/*
	 * VehicleService class is used to
	 * load vehicle details from the input text file
	 * to add new vehicle
	 * to display vehicle details
	 * to search for vehicle
	 * to calculate total rent
	 */
public class VehicleService {
	DataAccess data=new DataAccess();
	List<Vehicle> vehicleList;
	/*
	 * loads the vehicle data from vehicle.txt
	 * adds the vehicles to vehicleList
	 */
	public List<Vehicle> loadVehicles() throws VehicleException {

		vehicleList=data.loadVehicles();
		return vehicleList;
		
	}
	/*
	 * adds new vehicle to vehicleList
	 * @param vehicle is of type Vehicle 
	 */
	public List<Vehicle> addVehicles(Vehicle vehicle) {
		vehicleList.add(vehicle);
		return vehicleList;
		
	}
	/*
	 * to display all the vehicles in the list
	 */
	public void displayAllVehicleDetails() {
		for(Vehicle v:vehicleList) {
			System.out.println(v.displayDetails());
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
