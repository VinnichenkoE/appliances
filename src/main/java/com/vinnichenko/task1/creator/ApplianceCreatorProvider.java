package com.vinnichenko.task1.creator;

import com.vinnichenko.task1.creator.impl.*;
import com.vinnichenko.task1.entity.impl.ApplianceType;

import java.util.HashMap;
import java.util.Map;

public class ApplianceCreatorProvider {
    private final Map<String, ApplianceCreator> repository = new HashMap<>();

    public ApplianceCreatorProvider() {
        repository.put(ApplianceType.OVEN.getName(), new OvenCreator());
        repository.put(ApplianceType.LAPTOP.getName(), new LaptopCreator());
        repository.put(ApplianceType.REFRIGERATOR.getName(), new RefrigeratorCreator());
        repository.put(ApplianceType.SPEAKERS.getName(), new SpeakerCreator());
        repository.put(ApplianceType.TABLET_PC.getName(), new TabletPCCreator());
        repository.put(ApplianceType.VACUUM_CLEANER.getName(), new VacuumCleanerCreator());
    }

    public ApplianceCreator getApplianceCreator(String applianceName) {
        ApplianceCreator creator = repository.get(applianceName);
        return creator;
    }
}
