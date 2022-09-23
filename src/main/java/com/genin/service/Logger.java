package com.genin.service;

import java.time.LocalDateTime;

public final class Logger {
    private static Logger INSTANCE = new Logger();
    private final String logMessageSample = "%s: %s - %s -> %s";

    private Logger() {}

    public static Logger getInstance() {
        return INSTANCE;
    }

    public String generateLogMessage(LogType type, String message) {
        return String.format(logMessageSample, type, new Throwable().getStackTrace()[1].getClassName(), new Throwable().getStackTrace()[1].getMethodName(), message);
    }
    public void log(String logMessage) {
        System.out.println(LocalDateTime.now() + " :: " + logMessage);
    }
}
