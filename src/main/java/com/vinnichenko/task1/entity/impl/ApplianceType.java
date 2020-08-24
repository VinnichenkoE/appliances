package com.vinnichenko.task1.entity.impl;

public enum ApplianceType {

    OVEN("Oven"),
    LAPTOP("Laptop"),
    REFRIGERATOR("Refrigerator"),
    VACUUM_CLEANER("VacuumCleaner"),
    TABLET_PC("TabletPC"),
    SPEAKERS("Speakers");

    private String name;

    ApplianceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
