package com.vinnichenko.task1.service;

import com.vinnichenko.task1.entity.Appliance;
import com.vinnichenko.task1.entity.criteria.Criteria;
import com.vinnichenko.task1.exception.ServiceException;

import java.util.List;

public interface ApplianceService {	
	
	List<Appliance> find(Criteria criteria) throws ServiceException;
}
