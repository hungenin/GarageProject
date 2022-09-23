package com.genin.model;

public class Motorbike extends Vehicle {
    private static final int MINIMUM_NUMBER_OF_WHEELS = 2;
    private static final int MAXIMUM_NUMBER_OF_WHEELS = 3;
    private static final int MINIMUM_SIZE_IN_CENTIMETER = 160;
    private static final int MAXIMUM_SIZE_IN_CENTIMETER = 220;
    private final boolean hasSidecar;

    public Motorbike(int year, String color, int numberOfWheels, int sizeInCentimeter, String owner, boolean hasSidecar) {
        super(year, color, numberOfWheels, sizeInCentimeter, owner, MINIMUM_NUMBER_OF_WHEELS, MAXIMUM_NUMBER_OF_WHEELS, MINIMUM_SIZE_IN_CENTIMETER, MAXIMUM_SIZE_IN_CENTIMETER);

        this.hasSidecar = hasSidecar;
    }

    @Override
    public String toString() {
        return super.toString() + ", sidecar: " + hasSidecar;
    }
}
