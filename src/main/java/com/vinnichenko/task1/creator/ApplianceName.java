package com.vinnichenko.task1.creator;

public enum ApplianceName {

    OVEN("Oven"),
    LAPTOP("Laptop"),
    REFRIGERATOR("Refrigerator"),
    VACUUM_CLEANER("VacuumCleaner"),
    TABLET_PC("TabletPC"),
    SPEAKERS("Speakers");

    private String name;

    public String getName() {
        return name;
    }

    ApplianceName(String name) {
        this.name = name;
    }


}
