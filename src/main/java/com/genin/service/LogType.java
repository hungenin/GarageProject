package com.genin.service;

public enum LogType {
    INFO("Info"), WARNING("Warning"), ERROR("Error");

    private String type;

    LogType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
