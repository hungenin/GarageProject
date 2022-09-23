package com.genin.model;

import com.genin.service.GovernmentWindow;
import com.genin.service.LogType;
import com.genin.service.Logger;

public abstract class Vehicle {
    private static final int MINIMUM_PRODUCTION_YEAR = 1900;
    private static final int MAXIMUM_PRODUCTION_YEAR = 2022;
    private final int id;
    private final int productionYear;
    private final String color;
    private final int numberOfWheels;
    private final int sizeInCentimeter;
    private final String owner;
    private final int minimumNumberOfWheels;
    private final int maximumNumberOfWheels;
    private final int minimumSizeInCentimeter;
    private final int maximumSizeInCentimeter;

    public Vehicle(int productionYear, String color, int numberOfWheels, int sizeInCentimeter, String owner, int minimumNumberOfWheels, int maximumNumberOfWheels, int minimumSizeInCentimeter, int maximumSizeInCentimeter) {
        this.minimumNumberOfWheels = minimumNumberOfWheels;
        this.maximumNumberOfWheels = maximumNumberOfWheels;
        this.minimumSizeInCentimeter = minimumSizeInCentimeter;
        this.maximumSizeInCentimeter = maximumSizeInCentimeter;

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

    private boolean numberOfWheelsIsInvalid(int numberOfWheels) {
        return numberOfWheels < minimumNumberOfWheels || numberOfWheels > maximumNumberOfWheels;
    }

    private boolean sizeInCentimeterIsInvalid(int sizeInCentimeter) {
        return sizeInCentimeter < minimumSizeInCentimeter || sizeInCentimeter > maximumSizeInCentimeter;
    }

    private boolean ownerIsInvalid(String owner) {
        return owner.isEmpty();
    }
}
