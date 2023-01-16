package com.raimondas.bites.exception;


public class ErrorDetails {

    private String property;
    private String message;

    public ErrorDetails(String property, String message) {
        this.property = property;
        this.message = message;
    }

    public String getProperty() {
        return property;
    }

    public String getMessage() {
        return message;
    }
}
