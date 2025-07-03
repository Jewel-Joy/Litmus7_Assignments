package com.ltmus7.vehicleservice.service;
import java.util.List;

import com.litmus7.vehicleservice.dataaccess.DataAccess;
import com.litmus7.vehicleservice.dto.Vehicle;
import com.litmus7.vehicleservice.exception.VehicleDataException;
import com.litmus7.vehicleservice.exception.VehicleServiceException;
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
	private List<Vehicle> vehicleList;
	/*
	 * loads the vehicle data from vehicle.txt
	 * adds the vehicles to vehicleList
	 */
	public List<Vehicle> loadVehicles() throws VehicleServiceException {

		try {
			vehicleList=data.loadVehicles();
		} catch (VehicleDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehicleList;
		
	}
	/*
	 * adds new vehicle to vehicleList
	 * @param vehicle is of type Vehicle 
	 */
    public List<Vehicle> addVehicles(Vehicle vehicle) throws VehicleServiceException {
        if (vehicle == null) {
            throw new VehicleServiceException("Cannot add a null vehicle.");
        }

        if (vehicleList == null) {
            throw new VehicleServiceException("Vehicle list is not initialized. Load vehicles first.");
        }

        vehicleList.add(vehicle);
        return vehicleList;
    }
	/*
	 * to display all the vehicles in the list
	 */
    public void displayAllVehicleDetails() throws VehicleServiceException {
        if (vehicleList == null || vehicleList.isEmpty()) {
            throw new VehicleServiceException("No vehicles available to display.");
        }

        for (Vehicle v : vehicleList) {
            System.out.println(v.displayDetails());
        }
    }
	/*
	 * search for vehicle using brand name and model name
	 * @param brand is String
	 * @param model is String
	 */
    public boolean vehicleSearch(String brand, String model) throws VehicleServiceException {
        if (vehicleList == null || vehicleList.isEmpty()) {
            throw new VehicleServiceException("No vehicles available to search.");
        }

        for (Vehicle v : vehicleList) {
            if ((v.getBrand()).equalsIgnoreCase(brand) && (v.getModel()).equalsIgnoreCase(model))
                return true;
        }

        return false;
    }
	/*
	 * calculate total rent of all vehicles
	 */
    public double totalRent() throws VehicleServiceException {
        if (vehicleList == null || vehicleList.isEmpty()) {
            throw new VehicleServiceException("No vehicles available to calculate rent.");
        }

        double total = 0;
        for (Vehicle v : vehicleList) {
            total += v.getRentalPricePerDay();
        }

        return total;
    }
}
