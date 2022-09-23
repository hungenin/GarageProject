package com.genin.model;

public enum CarType {
    COUPE("coupe"), SEDAN("sedan"), CABRIOLET("cabriolet"), SUV("suv");

    private String type;

    CarType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
