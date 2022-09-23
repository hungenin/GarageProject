package com.genin.model;

import com.genin.service.LogType;
import com.genin.service.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Garage {
    private int maxNumberOfParkingPlaces = 20;
    private final List<Vehicle> vehicles = new ArrayList<>();

    public Garage() {}

    public Garage(int maxNumberOfParkingPlaces) {
        if (maxNumberOfParkingPlaces <= 0)
            throw new RuntimeException(Logger.getInstance().generateLogMessage(LogType.ERROR, String.format("Invalid maximum number of parking places. ( maxNumberOfParkingPlaces = %d ).", maxNumberOfParkingPlaces)));

        this.maxNumberOfParkingPlaces = maxNumberOfParkingPlaces;
    }

    public void parkingVehicle(Vehicle vehicle) {
        if (vehicles.contains(vehicle)) {
            Logger.getInstance().log(Logger.getInstance().generateLogMessage(LogType.WARNING, String.format("Vehicle is already parking in the garage. (%s).", vehicle.getId())));
            return;
        }

        if (vehicles.size() == this.maxNumberOfParkingPlaces) {
            Logger.getInstance().log(Logger.getInstance().generateLogMessage(LogType.WARNING, String.format("Garage is full. Vehicle cannot parking: (%s).", vehicle.getId())));
            return;
        }

        vehicles.add(vehicle);
    }

    public void parkingVehicles(List<Vehicle> vehiclesToPark) {
        vehiclesToPark.forEach(this::parkingVehicle);
    }

    public void unparkingVehicle(Vehicle vehicle) {
        if (!vehicles.remove(vehicle))
            Logger.getInstance().log(Logger.getInstance().generateLogMessage(LogType.WARNING, String.format("Vehicle not parking in the garage! (%s).", vehicle.getId())));
    }

    public void unParkingVehicles(List<Vehicle> vehiclesToUnpark) {
        vehiclesToUnpark.forEach(this::unparkingVehicle);
    }

    public void unparkingAllVehicles() {
        vehicles.clear();
    }

    @Override
    public String toString() {
        if (vehicles.isEmpty())
            return String.format("Garage is empty. %d place(s) available", maxNumberOfParkingPlaces);

        if (maxNumberOfParkingPlaces - vehicles.size() == 0)
            return String.format("Garage is full. Parking vehicle(s): %s", getVehiclesIds(vehicles));

        return String.format("%d place(s) available. Parking vehicle(s): %s",
                maxNumberOfParkingPlaces - vehicles.size(), getVehiclesIds(vehicles));
    }

    private static String getVehiclesIds(List<Vehicle> vehicles) {
        return String.format("(%s)", vehicles.stream().map(vehicle -> "" + vehicle.getId()).collect(Collectors.joining("), (")));
    }
}
