package com.vinnichenko.task1.main;

import com.vinnichenko.task1.entity.Appliance;
import com.vinnichenko.task1.entity.criteria.Criteria;
import com.vinnichenko.task1.entity.criteria.SearchCriteria;
import com.vinnichenko.task1.exception.ServiceException;
import com.vinnichenko.task1.service.ApplianceService;
import com.vinnichenko.task1.service.ServiceFactory;

import java.util.List;

import static com.vinnichenko.task1.entity.criteria.SearchCriteria.Oven;

public class Main {

    public static void main(String[] args) throws ServiceException {
        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        Criteria criteriaRef = new Criteria(SearchCriteria.Refrigerator.class
                .getSimpleName());
        criteriaRef.add(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString(),
                15);
        List<Appliance> applianceList = service.find(criteriaRef);
        PrintApplianceInfo.print(applianceList);

        Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());
        criteriaOven.add(Oven.HEIGHT.toString(), 45.5);
        criteriaOven.add(Oven.DEPTH.toString(), 60);
        List<Appliance> applianceList2 = service.find(criteriaOven);
        PrintApplianceInfo.print(applianceList2);
    }
}
