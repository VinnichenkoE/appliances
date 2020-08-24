package com.vinnichenko.task1.creator.impl;

import com.vinnichenko.task1.creator.ApplianceCreator;
import com.vinnichenko.task1.entity.Appliance;
import com.vinnichenko.task1.entity.impl.TabletPC;

import java.util.Map;

import static com.vinnichenko.task1.entity.impl.ApplianceParameter.*;

public class TabletPCCreator implements ApplianceCreator {
    @Override
    public Appliance createAppliance(Map<String, String> parameters) {
        String stringBatteryCapacity = parameters.get(BATTERY_CAPACITY.name());
        double batteryCapacity = Double.parseDouble(stringBatteryCapacity);
        String stringDisplayInches = parameters.get(DISPLAY_INCHES.name());
        int displayInches = Integer.parseInt(stringDisplayInches);
        String stringMemoryRom = parameters.get(MEMORY_ROM.name());
        int memoryRom = Integer.parseInt(stringMemoryRom);
        String stringFlashMemoryCapacity = parameters.get(FLASH_MEMORY_CAPACITY.name());
        double flashMemoryCapacity = Double.parseDouble(stringFlashMemoryCapacity);
        String color = parameters.get(COLOR.name());
        Appliance appliance = new TabletPC(batteryCapacity, displayInches, memoryRom, flashMemoryCapacity, color);
        return appliance;
    }
}
