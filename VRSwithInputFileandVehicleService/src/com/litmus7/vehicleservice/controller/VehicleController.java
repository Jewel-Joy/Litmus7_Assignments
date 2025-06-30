package com.litmus7.vehicleservice.controller;
import com.litmus7.vehicleservice.dto.Vehicle;
import com.litmus7.vehicleservice.dto.VehicleService;
import com.litmus7.vehicleservice.exception.VehicleDataException;
import com.litmus7.vehicleservice.exception.VehicleServiceException;

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
		}catch(VehicleDataException e) {
			 return "Error: " + e.getMessage();
		}
		
	}
	/*
	 * it displays the vehicle list
	 */
	public void displayAllVehicleDetails() {
		try {
			service.displayAllVehicleDetails();
		} catch (VehicleServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*
	 * It validate whether the vehicle is added
	 */
	public String addVehicles(Vehicle v) {
		try {
			vehicles=service.addVehicles(v);
		} catch (VehicleServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
			if(service.vehicleSearch(brand, model))
				return "Vehicle Exist";
			else
				return "Vehicle not exist";
		} catch (VehicleServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error occurred while searching for vehicle";
		}
		
		
	}
	/*
	 * calculates the total rent
	 */
	public double totalRent()  {
		// TODO Auto-generated method stub
		try {
			return service.totalRent();
		} catch (VehicleServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0.0;
		}
		}

	
}
