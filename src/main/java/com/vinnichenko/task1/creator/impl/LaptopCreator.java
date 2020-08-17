package com.vinnichenko.task1.creator.impl;

import com.vinnichenko.task1.creator.ApplianceCreator;
import com.vinnichenko.task1.entity.Appliance;
import com.vinnichenko.task1.entity.impl.Laptop;

import static com.vinnichenko.task1.creator.impl.ApplianceParameter.*;

import java.util.Map;

public class LaptopCreator implements ApplianceCreator {
    @Override
    public Appliance createAppliance(Map<String, String> parameters) {
        String stringBatteryCapacity = parameters.get(BATTERY_CAPACITY);
        double batteryCapacity = Double.parseDouble(stringBatteryCapacity);
        String os = parameters.get(OS);
        String stringMemoryRom = parameters.get(MEMORY_ROM);
        int memoryRom = Integer.parseInt(stringMemoryRom);
        String stringSystemMemory = parameters.get(SYSTEM_MEMORY);
        double systemMemory = Double.parseDouble(stringSystemMemory);
        String stringCpu = parameters.get(CPU);
        double cpu = Double.parseDouble(stringCpu);
        String stringDisplayInches = parameters.get(DISPLAY_INCHES);
        int displayInches = Integer.parseInt(stringDisplayInches);
        Appliance appliance = new Laptop(batteryCapacity, displayInches, memoryRom, os, systemMemory, cpu);
        return appliance;
    }
}
