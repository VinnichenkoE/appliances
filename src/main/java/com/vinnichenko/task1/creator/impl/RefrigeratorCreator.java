package com.vinnichenko.task1.creator.impl;

import com.vinnichenko.task1.creator.ApplianceCreator;
import com.vinnichenko.task1.entity.Appliance;
import com.vinnichenko.task1.entity.impl.Refrigerator;

import static com.vinnichenko.task1.entity.impl.ApplianceParameter.*;

import java.util.Map;

public class RefrigeratorCreator implements ApplianceCreator {
    @Override
    public Appliance createAppliance(Map<String, String> parameters) {
        String stringPowerConsumption = parameters.get(POWER_CONSUMPTION.name());
        double powerConsumption = Double.parseDouble(stringPowerConsumption);
        String stringWeight = parameters.get(WEIGHT.name());
        double weight = Double.parseDouble(stringWeight);
        String stringFreezerCapacity = parameters.get(FREEZER_CAPACITY.name());
        double freezerCapacity = Double.parseDouble(stringFreezerCapacity);
        String stringOverallCapacity = parameters.get(OVERALL_CAPACITY.name());
        double overallCapacity = Double.parseDouble(stringOverallCapacity);
        String stringHeight = parameters.get(HEIGHT.name());
        double height = Double.parseDouble(stringHeight);
        String stringWidth = parameters.get(WIDTH.name());
        double width = Double.parseDouble(stringWidth);
        Appliance appliance = new Refrigerator(powerConsumption, weight, height, width, freezerCapacity, overallCapacity);
        return appliance;
    }
}
