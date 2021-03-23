package com.ayo.conversion.util;

public enum UnitOfMeasure {

    KILOMETER("Km"),
    MILE ("mi"),
    FAHRENHEIT("°F"),
    CELSIUS ("°C"),
    KILOGRAM("Kg");

    private final String description;

    UnitOfMeasure (String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
