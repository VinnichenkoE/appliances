package com.vinnichenko.task1.creator;

import com.vinnichenko.task1.entity.Appliance;

import java.util.Map;

public interface ApplianceCreator {
    Appliance createAppliance(Map<String, String> parameters);
}
