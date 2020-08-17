package com.vinnichenko.task1.creator.impl;

import com.vinnichenko.task1.creator.ApplianceCreator;
import com.vinnichenko.task1.entity.Appliance;
import com.vinnichenko.task1.entity.impl.Oven;

import static com.vinnichenko.task1.creator.impl.ApplianceParameter.*;

import java.util.Map;

public class OvenCreator implements ApplianceCreator {

    @Override
    public Appliance createAppliance(Map<String, String> parameters) {
        String stringPowerConsumption = parameters.get(POWER_CONSUMPTION);
        double powerConsumption = Double.parseDouble(stringPowerConsumption);
        String stringWeight = parameters.get(WEIGHT);
        double weight = Double.parseDouble(stringWeight);
        String stringCapacity = parameters.get(CAPACITY);
        double capacity = Double.parseDouble(stringCapacity);
        String stringDepth = parameters.get(DEPTH);
        double depth = Double.parseDouble(stringDepth);
        String stringHeight = parameters.get(HEIGHT);
        double height = Double.parseDouble(stringHeight);
        String stringWidth = parameters.get(WIDTH);
        double width = Double.parseDouble(stringWidth);
        Appliance appliance = new Oven(powerConsumption, weight, capacity, depth, height, width);
        return appliance;
    }
}
