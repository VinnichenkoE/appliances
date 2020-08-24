package com.vinnichenko.task1.dao.impl;

import com.vinnichenko.task1.creator.ApplianceCreator;
import com.vinnichenko.task1.creator.ApplianceCreatorProvider;
import com.vinnichenko.task1.dao.ApplianceDAO;
import com.vinnichenko.task1.entity.Appliance;
import com.vinnichenko.task1.entity.criteria.Criteria;
import com.vinnichenko.task1.exception.DaoException;
import com.vinnichenko.task1.parser.StringParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ApplianceDAOImpl implements ApplianceDAO {

    private static final String EQUALLY = "=";
    private static final String TYPE = "type";
    private static final String FILE = "file";
    private static final String KEY = "file.path";

    @Override
    public List<Appliance> find(Criteria criteria) throws DaoException {
        String groupSearchName = criteria.getGroupSearchName();
        Map<String, Object> criteriaParameters = criteria.getCriteria();
        String path;
        List<String> stringAppliances;
        BufferedReader bufferedReader = null;
        try {
            ResourceBundle resource = ResourceBundle.getBundle(FILE);
            path = resource.getString(KEY);
            bufferedReader = new BufferedReader(new FileReader(path));
            stringAppliances = searchLines(bufferedReader, groupSearchName, criteriaParameters);
        } catch (MissingResourceException | IOException ex) {
            throw new DaoException(ex);
        } finally {
            closeBufferReader(bufferedReader);
        }
        List<Appliance> applianceList = linesToAppliances(stringAppliances);
        return applianceList;
    }

    private List<String> searchLines(BufferedReader bufferedReader,
                                     String groupSearchName,
                                     Map<String, Object> criteriaParameters)
            throws IOException {
        List<String> stringAppliances = new ArrayList<>();
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            if (line.contains(groupSearchName)) {
                if (!criteriaParameters.isEmpty()) {
                    int count = 0;
                    for (String key : criteriaParameters.keySet()) {
                        StringBuilder stringBuilder = new StringBuilder(key);
                        stringBuilder.append(EQUALLY).append(criteriaParameters.get(key));
                        if (line.contains(stringBuilder.toString())) {
                            count++;
                        }
                    }
                    if (count == criteriaParameters.size()) {
                        stringAppliances.add(line);
                    }
                } else {
                    stringAppliances.add(line);
                }
            }
        }
        return stringAppliances;
    }

    private List<Appliance> linesToAppliances(List<String> stringAppliances) {
        StringParser stringParser = new StringParser();
        ApplianceCreatorProvider provider = new ApplianceCreatorProvider();
        List<Appliance> applianceList = new ArrayList<>();
        for (String stringAppliance : stringAppliances) {
            Map<String, String> parameters = stringParser.stringToParameters(stringAppliance);
            String applianceName = parameters.get(TYPE);
            ApplianceCreator creator = provider.getApplianceCreator(applianceName);
            Appliance appliance = creator.createAppliance(parameters);
            applianceList.add(appliance);
        }
        return applianceList;
    }
}