package com.raimondas.bites.entity;

public enum Type {

    INTERNET("Internetas"),
    MOBILE("Mobilusis_Rysys"),
    TELEVISION("Televizija");

    private final String label;

    Type(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
