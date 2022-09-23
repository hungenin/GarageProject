package com.genin.model;

public class Car extends Vehicle {
    private static final int MINIMUM_NUMBER_OF_WHEELS = 3;
    private static final int MAXIMUM_NUMBER_OF_WHEELS = 6;
    private static final int MINIMUM_SIZE_IN_CENTIMETER = 160;
    private static final int MAXIMUM_SIZE_IN_CENTIMETER = 400;
    private final CarType type;

    public Car(int year, String color, int numberOfWheels, int sizeInCentimeter, String owner, CarType type) {
        super(year, color, numberOfWheels, sizeInCentimeter, owner, MINIMUM_NUMBER_OF_WHEELS, MAXIMUM_NUMBER_OF_WHEELS, MINIMUM_SIZE_IN_CENTIMETER, MAXIMUM_SIZE_IN_CENTIMETER);

        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + ", type: " + type;
    }
}
