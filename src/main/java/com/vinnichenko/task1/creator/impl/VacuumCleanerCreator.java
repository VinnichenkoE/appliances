package com.vinnichenko.task1.creator.impl;

import com.vinnichenko.task1.creator.ApplianceCreator;
import com.vinnichenko.task1.entity.Appliance;
import com.vinnichenko.task1.entity.impl.VacuumCleaner;

import java.util.Map;

import static com.vinnichenko.task1.entity.impl.ApplianceParameter.*;

public class VacuumCleanerCreator implements ApplianceCreator {
    @Override
    public Appliance createAppliance(Map<String, String> parameters) {
        String stringPowerConsumption = parameters.get(POWER_CONSUMPTION.name());
        double powerConsumption = Double.parseDouble(stringPowerConsumption);
        String filterType = parameters.get(FILTER_TYPE.name());
        String bagType = parameters.get(BAG_TYPE.name());
        String wandType = parameters.get(WAND_TYPE.name());
        String stringMotorSpeedRegulation = parameters.get(MOTOR_SPEED_REGULATION.name());
        double motorSpeedRegulation = Double.parseDouble(stringMotorSpeedRegulation);
        String stringCleaningWidth = parameters.get(CLEANING_WIDTH.name());
        double cleaningWidth = Double.parseDouble(stringCleaningWidth);
        Appliance appliance = new VacuumCleaner(powerConsumption, filterType, bagType, wandType, motorSpeedRegulation, cleaningWidth);
        return appliance;
    }
}
