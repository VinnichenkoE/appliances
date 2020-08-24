package com.vinnichenko.task1.creator.impl;

import com.vinnichenko.task1.creator.ApplianceCreator;
import com.vinnichenko.task1.entity.Appliance;
import com.vinnichenko.task1.entity.impl.Speaker;

import java.util.Map;

import static com.vinnichenko.task1.entity.impl.ApplianceParameter.*;

public class SpeakerCreator implements ApplianceCreator {

    private static final String RANGE_SEPARATOR = "-";

    @Override
    public Appliance createAppliance(Map<String, String> parameters) {
        String stringPowerConsumption = parameters.get(POWER_CONSUMPTION.name());
        double powerConsumption = Double.parseDouble(stringPowerConsumption);
        String stringNumberOfSpeakers = parameters.get(NUMBER_SPEAKERS.name());
        int numberOfSpeakers = Integer.parseInt(stringNumberOfSpeakers);
        String frequencyRange = parameters.get(FREQUENCY_RANGE.name());
        String[] frequencyArr = frequencyRange.split(RANGE_SEPARATOR);
        double startFrequencyRange = Double.parseDouble(frequencyArr[0]);
        double endFrequencyRange = Double.parseDouble(frequencyArr[1]);
        String stringCordLength = parameters.get(CORD_LENGTH.name());
        double cordLength = Double.parseDouble(stringCordLength);
        Appliance appliance = new Speaker(powerConsumption, numberOfSpeakers, startFrequencyRange, endFrequencyRange, cordLength);
        return appliance;
    }
}
