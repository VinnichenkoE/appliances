package com.vinnichenko.task1.service.validator;

import com.vinnichenko.task1.entity.criteria.Criteria;
import com.vinnichenko.task1.entity.impl.ApplianceParameter;
import com.vinnichenko.task1.entity.impl.ApplianceType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Validator {

    public boolean criteriaValidator(Criteria criteria) {
        String groupSearchName = criteria.getGroupSearchName();
        Map<String, Object> parameters = criteria.getCriteria();
        if (!isGroupSearchNameValid(groupSearchName)) {
        	return false;
		}
        return isParametersValid(parameters);
    }

    private boolean isGroupSearchNameValid(String groupSearchName) {
        boolean result = false;
        ApplianceType[] types = ApplianceType.values();
        for (int i = 0; i < types.length; i++) {
            if (groupSearchName.equals(types[i].getName())) {
                result = true;
            }
        }
        return result;
    }

    private boolean isParametersValid(Map<String, Object> parameters) {
        boolean result = true;
        Set<String> keys = parameters.keySet();
        List<String> param = Arrays.stream(ApplianceParameter.values())
                .map(a -> a.name()).collect(Collectors.toList());
        for (String key : keys) {
			if (!param.contains(key)) {
				result = false;
				break;
			}
        }
        return result;
    }
}
