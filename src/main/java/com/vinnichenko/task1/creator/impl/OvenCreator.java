package com.vinnichenko.task1.creator.impl;

import com.vinnichenko.task1.creator.ApplianceCreator;
import com.vinnichenko.task1.entity.Appliance;
import com.vinnichenko.task1.entity.impl.Oven;

import static com.vinnichenko.task1.entity.impl.ApplianceParameter.*;

import java.util.Map;

public class OvenCreator implements ApplianceCreator {

    @Override
    public Appliance createAppliance(Map<String, String> parameters) {
        String stringPowerConsumption = parameters.get(POWER_CONSUMPTION.name());
        double powerConsumption = Double.parseDouble(stringPowerConsumption);
        String stringWeight = parameters.get(WEIGHT.name());
        double weight = Double.parseDouble(stringWeight);
        String stringCapacity = parameters.get(CAPACITY.name());
        double capacity = Double.parseDouble(stringCapacity);
        String stringDepth = parameters.get(DEPTH.name());
        double depth = Double.parseDouble(stringDepth);
        String stringHeight = parameters.get(HEIGHT.name());
        double height = Double.parseDouble(stringHeight);
        String stringWidth = parameters.get(WIDTH.name());
        double width = Double.parseDouble(stringWidth);
        Appliance appliance = new Oven(powerConsumption, weight, capacity, depth, height, width);
        return appliance;
    }
}
