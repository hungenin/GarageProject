package com.genin.model;

public class Truck extends Vehicle{
    private static final int MINIMUM_NUMBER_OF_WHEELS = 4;
    private static final int MAXIMUM_NUMBER_OF_WHEELS = 18;
    private static final int MINIMUM_SIZE_IN_CENTIMETER = 300;
    private static final int MAXIMUM_SIZE_IN_CENTIMETER = 1000;
    private final boolean isOversize;

    public Truck(int year, String color, int numberOfWheels, int sizeInCentimeter, String owner, boolean isOversize) {
        super(year, color, numberOfWheels, sizeInCentimeter, owner);

        this.isOversize = isOversize;
    }

    @Override
    protected boolean numberOfWheelsIsInvalid(int numberOfWheels) {
        return numberOfWheels < MINIMUM_NUMBER_OF_WHEELS || numberOfWheels > MAXIMUM_NUMBER_OF_WHEELS;
    }

    @Override
    protected boolean sizeInCentimeterIsInvalid(int sizeInCentimeter) {
        return sizeInCentimeter < MINIMUM_SIZE_IN_CENTIMETER || sizeInCentimeter > MAXIMUM_SIZE_IN_CENTIMETER;
    }

    @Override
    public String toString() {
        return super.toString() + ", oversize: " + isOversize;
    }
}
