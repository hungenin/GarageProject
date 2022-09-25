package com.genin.model;

import com.genin.service.GovernmentWindow;
import com.genin.service.LogType;
import com.genin.service.Logger;

public abstract class Vehicle {
    private static final int MINIMUM_PRODUCTION_YEAR = 1900;
    private static final int MAXIMUM_PRODUCTION_YEAR = 2022;
    private static final int MINIMUM_NUMBER_OF_WHEELS = 0;
    private static final int MAXIMUM_NUMBER_OF_WHEELS = 100;
    private static final int MINIMUM_SIZE_IN_CENTIMETER = 0;
    private static final int MAXIMUM_SIZE_IN_CENTIMETER = 10000;
    private final int id;
    private final int productionYear;
    private final String color;
    private final int numberOfWheels;
    private final int sizeInCentimeter;
    private final String owner;

    public Vehicle(int productionYear, String color, int numberOfWheels, int sizeInCentimeter, String owner) {
        String errorMessage = getErrorMessageIfAnyParameterInvalid(productionYear, color, numberOfWheels, sizeInCentimeter, owner);
        if (!errorMessage.isEmpty())
            throw new RuntimeException(Logger.getInstance().generateLogMessage(LogType.ERROR, errorMessage));

        id = GovernmentWindow.getInstance().getId();
        this.productionYear = productionYear;
        this.color = color;
        this.numberOfWheels = numberOfWheels;
        this.sizeInCentimeter = sizeInCentimeter;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("id: %d, production year: %d, color: %s, number of wheels: %d, size: %d, owner: %s",
                                id, productionYear, color, numberOfWheels, sizeInCentimeter, owner);
    }

    private String getErrorMessageIfAnyParameterInvalid(int productionYear, String color, int numberOfWheels, int sizeInCentimeter, String owner) {
        StringBuilder errorMessage = new StringBuilder("");
        if (productionYearIsInvalid(productionYear)) errorMessage.append(" Invalid production year.");
        if (colorIsInvalid(color)) errorMessage.append(" Invalid color.");
        if (numberOfWheelsIsInvalid(numberOfWheels)) errorMessage.append(" Invalid number of wheels.");
        if (sizeInCentimeterIsInvalid(sizeInCentimeter)) errorMessage.append(" Invalid size.");
        if (ownerIsInvalid(owner)) errorMessage.append(" Invalid owner name.");

        return errorMessage.toString();
    }

    private boolean productionYearIsInvalid(int productionYear) {
        return productionYear < MINIMUM_PRODUCTION_YEAR || productionYear > MAXIMUM_PRODUCTION_YEAR;
    }

    private boolean colorIsInvalid(String color) {
        return color.isEmpty();
    }

    protected boolean numberOfWheelsIsInvalid(int numberOfWheels) {
        return numberOfWheels < MINIMUM_NUMBER_OF_WHEELS || numberOfWheels > MAXIMUM_NUMBER_OF_WHEELS;
    }

    protected boolean sizeInCentimeterIsInvalid(int sizeInCentimeter) {
        return sizeInCentimeter < MINIMUM_SIZE_IN_CENTIMETER || sizeInCentimeter > MAXIMUM_SIZE_IN_CENTIMETER;
    }

    private boolean ownerIsInvalid(String owner) {
        return owner.isEmpty();
    }
}
