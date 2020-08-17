package com.vinnichenko.task1.main;

import com.vinnichenko.task1.entity.Appliance;
import com.vinnichenko.task1.entity.criteria.Criteria;
import com.vinnichenko.task1.entity.criteria.SearchCriteria;
import com.vinnichenko.task1.exception.ServiceException;
import com.vinnichenko.task1.service.ApplianceService;
import com.vinnichenko.task1.service.ServiceFactory;

import java.util.List;

import static com.vinnichenko.task1.entity.criteria.SearchCriteria.Oven;
import static com.vinnichenko.task1.entity.criteria.SearchCriteria.TabletPC;

public class Main {

    public static void main(String[] args) throws ServiceException {
        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();

        //////////////////////////////////////////////////////////////////

        Criteria criteriaOven = new Criteria(SearchCriteria.Refrigerator.class.getSimpleName());
        criteriaOven.add(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString(), 15);
        List<Appliance> applianceList = service.find(criteriaOven);

        PrintApplianceInfo.print(applianceList);

        //////////////////////////////////////////////////////////////////

        criteriaOven = new Criteria(Oven.class.getSimpleName());
        criteriaOven.add(Oven.HEIGHT.toString(), 200);
        criteriaOven.add(Oven.DEPTH.toString(), 300);

        applianceList = service.find(criteriaOven);

        PrintApplianceInfo.print(applianceList);

        //////////////////////////////////////////////////////////////////

        Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
        criteriaTabletPC.add(TabletPC.COLOR.toString(), "BLUE");
        criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 14);
        criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 4);

        applianceList = service.find(criteriaOven);// find(Object...obj)

        PrintApplianceInfo.print(applianceList);
    }
}
