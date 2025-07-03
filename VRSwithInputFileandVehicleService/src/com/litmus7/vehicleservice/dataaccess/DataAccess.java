package com.litmus7.vehicleservice.dataaccess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.vehicleservice.dto.Bike;
import com.litmus7.vehicleservice.dto.Car;
import com.litmus7.vehicleservice.dto.Vehicle;
import com.litmus7.vehicleservice.exception.VehicleDataException;
/*
 * DataAccess class access the data from the vehicle.txt
 */

public class DataAccess {
		List<Vehicle> vehicle=new ArrayList<>();
			public List<Vehicle> loadVehicles() throws VehicleDataException {
			    try(BufferedReader br = new BufferedReader(new FileReader("src/vehicle.txt"))) {
			        
			        String line;
			        while ((line = br.readLine()) != null) {
			            String[] parts = line.split(",");
			            if (parts[0].equalsIgnoreCase("Car")) {
			                String brand = parts[1];
			                String model = parts[2];
			                double rentPricePerDay = Double.parseDouble(parts[3]);
			                int numberOfDoors = Integer.parseInt(parts[4]);
			                boolean isAutomatic = Boolean.parseBoolean(parts[5]);
			                Car car = new Car(brand, model, rentPricePerDay, numberOfDoors, isAutomatic);
			                vehicle.add(car);
			            } else {
			                String brand = parts[1];
			                String model = parts[2];
			                double rentPricePerDay = Double.parseDouble(parts[3]);
			                boolean hasGears = Boolean.parseBoolean(parts[4]);
			                int engineCapacity = Integer.parseInt(parts[5]);
			                Bike bike = new Bike(brand, model, rentPricePerDay, engineCapacity, hasGears);
			                vehicle.add(bike);
			            }
			        }
			        br.close();
			    } catch (FileNotFoundException e) {
			        throw new VehicleDataException("Vehicle file not found.");
			    } catch (IOException e) {
			        throw new VehicleDataException("Error reading vehicle file.");
			    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
			        throw new VehicleDataException("Invalid data format in vehicle file.");
			    }

			    return vehicle;
			}

		


}
