package com.litmus7.vehicleservice.controller;
import com.litmus7.vehicleservice.dto.Vehicle;
import com.litmus7.vehicleservice.dto.VehicleService;
import com.litmus7.vehicleservice.exception.VehicleException;
import java.util.List;
/*
 * this class act as the link
 * between the UI and the service
 */
public class VehicleController {
	List<Vehicle> vehicles;
	VehicleService service=new VehicleService();
	/*
	 * it access the data from the vehicle.txt through 
	 * the class DataAccess
	 */
	public String loadVehicles() {
		try {
		
		vehicles=service.loadVehicles();
		if(vehicles.isEmpty())
			return "File is empty";
		else
			return "Loaded the data in the file";
		}catch(VehicleException e) {
			 return "Error: " + e.getMessage();
		}
		
	}
	/*
	 * it displays the vehicle list
	 */
	public void displayAllVehicleDetails() {
		service.displayAllVehicleDetails();
		
	}
	/*
	 * It validate whether the vehicle is added
	 */
	public String addVehicles(Vehicle v) {
		vehicles=service.addVehicles(v);
		if(vehicles.contains(v))
			return "Vehicle added";
		else
			return "Vehicle not added";
			
		
	}
	/*
	 * @param brand is of type String
	 * @param model is of type String
	 * validates whether the vehicle exist or not
	 */
	public String vehicleSearch(String brand, String model) {
		if(service.vehicleSearch(brand, model))
			return "Vehicle Exist";
		else
			return "Vehicle not exist";
		
		
	}
	/*
	 * calculates the total rent
	 */
	public double totalRent() {
		// TODO Auto-generated method stub
		return service.totalRent();
		}

	
}
