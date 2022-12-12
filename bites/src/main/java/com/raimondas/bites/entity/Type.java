package com.raimondas.bites.entity;

public enum Type {

    INTERNET("Int"),
    MOBILE("Mob"),
    TELEVISION("TV");

    private final String label;

    Type(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
