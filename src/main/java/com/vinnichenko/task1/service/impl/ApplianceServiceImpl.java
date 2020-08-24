package com.vinnichenko.task1.service.impl;

import com.vinnichenko.task1.dao.ApplianceDAO;
import com.vinnichenko.task1.dao.DAOFactory;
import com.vinnichenko.task1.entity.Appliance;
import com.vinnichenko.task1.entity.criteria.Criteria;
import com.vinnichenko.task1.exception.DaoException;
import com.vinnichenko.task1.exception.ServiceException;
import com.vinnichenko.task1.service.ApplianceService;
import com.vinnichenko.task1.service.validator.Validator;

import java.util.List;

public class ApplianceServiceImpl implements ApplianceService {

	@Override
	public List<Appliance> find(Criteria criteria) throws ServiceException {
		Validator validator = new Validator();
		if (!validator.criteriaValidator(criteria)) {
			throw new ServiceException("incorrect criteria");
		}
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO dao = factory.getApplianceDAO();
		List<Appliance> appliances;
		try {
			appliances = dao.find(criteria);
		} catch (DaoException ex) {
			throw new ServiceException(ex);
		}
		return appliances;
	}
}