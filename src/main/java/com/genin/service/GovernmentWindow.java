package com.genin.service;

public final class GovernmentWindow {
    private static GovernmentWindow INSTANCE = new GovernmentWindow();
    private int idCounter = 0;

    private GovernmentWindow(){}

    public static GovernmentWindow getInstance() {
        return INSTANCE;
    }

    public int getId() {
        return idCounter++;
    }
}
