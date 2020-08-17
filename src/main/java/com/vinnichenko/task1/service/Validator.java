package com.vinnichenko.task1.service;

import com.vinnichenko.task1.entity.criteria.Criteria;
import com.vinnichenko.task1.entity.criteria.SearchCriteria;

public class Validator {
	
	public static boolean criteriaValidator(Criteria criteria) {
		boolean result = false;
		String groupSearchName = criteria.getGroupSearchName();
		Class[] classes = SearchCriteria.class.getDeclaredClasses();
		for (int i = 0; i < classes.length; i++) {
			if (groupSearchName.equalsIgnoreCase(classes[i].getSimpleName())) {
				result = true;
			}
		}
		return result;
	}
}
