package com.litmus7.vehicleservice.controller;

import com.litmus7.vehicleservice.dto.Response;
import com.litmus7.vehicleservice.dto.Vehicle;
import com.litmus7.vehicleservice.exception.VehicleServiceException;
import com.ltmus7.vehicleservice.service.VehicleService;

import java.util.List;

public class VehicleController {

    private final int SUCCESS_STATUS_CODE = 200;
    private final int ERROR_STATUS_CODE = 400;

    private VehicleService service = new VehicleService();

    public Response<List<Vehicle>> loadVehicles() {
        Response<List<Vehicle>> response = new Response<>();
        try {
            List<Vehicle> vehicles = service.loadVehicles();
            if (vehicles.isEmpty()) {
                response.setStatusCode(ERROR_STATUS_CODE);
                response.setErrorMessage("File is empty");
            } else {
                response.setStatusCode(SUCCESS_STATUS_CODE);
                response.setData(vehicles);
                
            }
        } catch (VehicleServiceException e) {
            response.setStatusCode(ERROR_STATUS_CODE);
            response.setErrorMessage("Error loading vehicle data: " + e.getMessage());
        }
        return response;
    }

    public Response<String> displayAllVehicleDetails() {
        Response<String> response = new Response<>();
        try {
            service.displayAllVehicleDetails(); // This prints to console
            response.setStatusCode(SUCCESS_STATUS_CODE);
            response.setData("Displayed all vehicle details");
        } catch (VehicleServiceException e) {
            response.setStatusCode(ERROR_STATUS_CODE);
            response.setErrorMessage("Error displaying vehicles: " + e.getMessage());
        }
        return response;
    }

    public Response<List<Vehicle>> addVehicle(Vehicle v) {
        Response<List<Vehicle>> response = new Response();
        try {
            List<Vehicle> updatedList = service.addVehicles(v);
            if (updatedList.contains(v)) {
                response.setStatusCode(SUCCESS_STATUS_CODE);
                response.setData(updatedList);
                
            } else {
                response.setStatusCode(ERROR_STATUS_CODE);
                response.setErrorMessage("Vehicle not added");
            }
        } catch (VehicleServiceException e) {
            response.setStatusCode(ERROR_STATUS_CODE);
            response.setErrorMessage("Error adding vehicle: " + e.getMessage());
        }
        return response;
    }

    public Response<String> vehicleSearch(String brand, String model) {
        Response<String> response = new Response<>();
        try {
            if (service.vehicleSearch(brand, model)) {
                response.setStatusCode(SUCCESS_STATUS_CODE);
                response.setData("Vehicle exists");
            } else {
                response.setStatusCode(ERROR_STATUS_CODE);
                response.setErrorMessage("Vehicle does not exist");
            }
        } catch (VehicleServiceException e) {
            response.setStatusCode(ERROR_STATUS_CODE);
            response.setErrorMessage("Error searching for vehicle: " + e.getMessage());
        }
        return response;
    }

    public Response<String> totalRent() {
        Response<String> response = new Response<>();
        try {
            double rent = service.totalRent();
            response.setStatusCode(SUCCESS_STATUS_CODE);
            response.setData("Total Rent: " + rent);
        } catch (VehicleServiceException e) {
            response.setStatusCode(ERROR_STATUS_CODE);
            response.setErrorMessage("Error calculating total rent: " + e.getMessage());
        }
        return response;
    }
}
