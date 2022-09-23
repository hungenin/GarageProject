package com.genin.model;

public class Truck extends Vehicle{
    private static final int MINIMUM_NUMBER_OF_WHEELS = 4;
    private static final int MAXIMUM_NUMBER_OF_WHEELS = 18;
    private static final int MINIMUM_SIZE_IN_CENTIMETER = 300;
    private static final int MAXIMUM_SIZE_IN_CENTIMETER = 1000;
    private final boolean isOversize;

    public Truck(int year, String color, int numberOfWheels, int sizeInCentimeter, String owner, boolean isOversize) {
        super(year, color, numberOfWheels, sizeInCentimeter, owner, MINIMUM_NUMBER_OF_WHEELS, MAXIMUM_NUMBER_OF_WHEELS, MINIMUM_SIZE_IN_CENTIMETER, MAXIMUM_SIZE_IN_CENTIMETER);

        this.isOversize = isOversize;
    }

    @Override
    public String toString() {
        return super.toString() + ", oversize: " + isOversize;
    }
}
