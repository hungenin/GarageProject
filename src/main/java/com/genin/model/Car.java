package com.genin.model;

public class Car extends Vehicle {
    private static final int MINIMUM_NUMBER_OF_WHEELS = 3;
    private static final int MAXIMUM_NUMBER_OF_WHEELS = 6;
    private static final int MINIMUM_SIZE_IN_CENTIMETER = 160;
    private static final int MAXIMUM_SIZE_IN_CENTIMETER = 400;
    private final CarType type;

    public Car(int year, String color, int numberOfWheels, int sizeInCentimeter, String owner, CarType type) {
        super(year, color, numberOfWheels, sizeInCentimeter, owner);

        this.type = type;
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
        return super.toString() + ", type: " + type;
    }
}
