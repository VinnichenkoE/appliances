package com.vinnichenko.task1.creator;

import com.vinnichenko.task1.creator.impl.LaptopCreator;
import com.vinnichenko.task1.creator.impl.OvenCreator;
import com.vinnichenko.task1.creator.impl.RefrigeratorCreator;

import java.util.HashMap;
import java.util.Map;

public class ApplianceCreatorProvider {
    private final Map<String, ApplianceCreator> repository = new HashMap<>();

    public ApplianceCreatorProvider() {
        repository.put(ApplianceName.OVEN.getName(), new OvenCreator());
        repository.put(ApplianceName.LAPTOP.getName(), new LaptopCreator());
        repository.put(ApplianceName.REFRIGERATOR.getName(), new RefrigeratorCreator());
    }

    public ApplianceCreator getApplianceCreator(String applianceName) {
        ApplianceCreator creator = repository.get(applianceName);
        return creator;
    }
}
