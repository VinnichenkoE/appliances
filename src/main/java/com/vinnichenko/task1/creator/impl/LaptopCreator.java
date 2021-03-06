package com.vinnichenko.task1.creator.impl;

import com.vinnichenko.task1.creator.ApplianceCreator;
import com.vinnichenko.task1.entity.Appliance;
import com.vinnichenko.task1.entity.impl.Laptop;

import java.util.Map;

import static com.vinnichenko.task1.entity.impl.ApplianceParameter.*;

public class LaptopCreator implements ApplianceCreator {
    @Override
    public Appliance createAppliance(Map<String, String> parameters) {
        String stringBatteryCapacity = parameters.get(BATTERY_CAPACITY.name());
        double batteryCapacity = Double.parseDouble(stringBatteryCapacity);
        String os = parameters.get(OS.name());
        String stringMemoryRom = parameters.get(MEMORY_ROM.name());
        int memoryRom = Integer.parseInt(stringMemoryRom);
        String stringSystemMemory = parameters.get(SYSTEM_MEMORY.name());
        double systemMemory = Double.parseDouble(stringSystemMemory);
        String stringCpu = parameters.get(CPU.name());
        double cpu = Double.parseDouble(stringCpu);
        String stringDisplayInches = parameters.get(DISPLAY_INCHES.name());
        int displayInches = Integer.parseInt(stringDisplayInches);
        Appliance appliance = new Laptop(batteryCapacity, displayInches, memoryRom, os, systemMemory, cpu);
        return appliance;
    }
}
