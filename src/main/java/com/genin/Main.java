package com.genin;

import com.genin.model.*;
import com.genin.service.LogType;
import com.genin.service.Logger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Logger.getInstance().log(Logger.getInstance().generateLogMessage(LogType.INFO, "Create garage with wrong parameter."));
        try {
            new Garage(0);
        } catch (RuntimeException exception) {
            Logger.getInstance().log(exception.getMessage());
        }
        System.out.println();

        Logger.getInstance().log(Logger.getInstance().generateLogMessage(LogType.INFO, "Create garage without parameter."));
        Garage garage1 = new Garage();
        System.out.println("Garage1 -> " + garage1);
        System.out.println();

        Logger.getInstance().log(Logger.getInstance().generateLogMessage(LogType.INFO, "Create garage with parameter."));
        Garage garage2 = new Garage(5);
        System.out.println("Garage2 -> " + garage2);
        System.out.println();

        Logger.getInstance().log(Logger.getInstance().generateLogMessage(LogType.INFO, "Create car with wrong parameters."));
        try {
            new Car(-2000, "red", 2, 10, "", CarType.SUV);
        } catch (RuntimeException exception) {
            Logger.getInstance().log(exception.getMessage());
        }
        System.out.println();

        Logger.getInstance().log(Logger.getInstance().generateLogMessage(LogType.INFO, "Create motorbike with wrong parameters."));
        try {
            new Motorbike(2000, "", 4, 3500, "Bill", true);
        } catch (RuntimeException exception) {
            Logger.getInstance().log(exception.getMessage());
        }
        System.out.println();

        Logger.getInstance().log(Logger.getInstance().generateLogMessage(LogType.INFO, "Create truck with wrong parameters."));
        try {
            new Truck(2000, "red", 20, 200, "", false);
        } catch (RuntimeException exception) {
            Logger.getInstance().log(exception.getMessage());
        }
        System.out.println();

        Logger.getInstance().log(Logger.getInstance().generateLogMessage(LogType.INFO, "Create vehicles with good parameters."));
        Vehicle vehicle1 = new Car(2000, "red", 4, 350, "Bill", CarType.SEDAN);
        Vehicle vehicle2 = new Truck(1998, "black", 6, 420, "Paul", false);
        Vehicle vehicle3 = new Car(2007, "pink", 4, 275, "Mark", CarType.CABRIOLET);
        Vehicle vehicle4 = new Car(1963, "gray", 4, 240, "Joe", CarType.COUPE);
        Vehicle vehicle5 = new Car(1989, "blue", 4, 310, "Karl", CarType.SUV);
        Vehicle vehicle6 = new Motorbike(2016, "white", 2, 180, "Otto", true);
        System.out.println("New vehicles:");
        System.out.println(vehicle1);
        System.out.println(vehicle2);
        System.out.println(vehicle3);
        System.out.println(vehicle4);
        System.out.println(vehicle5);
        System.out.println(vehicle6);
        System.out.println();

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle4);
        vehicles.add(vehicle5);
        vehicles.add(vehicle2);
        vehicles.add(vehicle3);
        vehicles.add(vehicle6);
        System.out.println("Vehicle list:");
        vehicles.forEach(System.out::println);
        System.out.println();

        Logger.getInstance().log(Logger.getInstance().generateLogMessage(LogType.INFO, "Parking vehicle (x3)."));
        garage2.parkingVehicle(vehicle1);
        garage2.parkingVehicle(vehicle2);
        garage2.parkingVehicle(vehicle3);
        System.out.println("Garage2 -> " + garage2);
        System.out.println();

        Logger.getInstance().log(Logger.getInstance().generateLogMessage(LogType.INFO, "Parking vehicle that is already parked."));
        garage2.parkingVehicle(vehicle2);
        System.out.println("Garage2 -> " + garage2);
        System.out.println();

        Logger.getInstance().log(Logger.getInstance().generateLogMessage(LogType.INFO, "Parking vehicles from list."));
        garage2.parkingVehicles(vehicles);
        System.out.println("Garage2 -> " + garage2);
        System.out.println();

        Logger.getInstance().log(Logger.getInstance().generateLogMessage(LogType.INFO, "Unparking vehicle."));
        garage2.unparkingVehicle(vehicle2);
        System.out.println("Garage2 -> " + garage2);
        System.out.println();

        Logger.getInstance().log(Logger.getInstance().generateLogMessage(LogType.INFO, "Unparking vehicle that is not parked."));
        garage2.unparkingVehicle(vehicle2);
        System.out.println("Garage2 -> " + garage2);
        System.out.println();

        Logger.getInstance().log(Logger.getInstance().generateLogMessage(LogType.INFO, "Unparking vehicles from list."));
        garage2.unParkingVehicles(vehicles);
        System.out.println("Garage2 -> " + garage2);
        System.out.println();

        Logger.getInstance().log(Logger.getInstance().generateLogMessage(LogType.INFO, "Empty garage2."));
        garage2.unparkingAllVehicles();
        System.out.println("Garage2 -> " + garage2);
    }
}