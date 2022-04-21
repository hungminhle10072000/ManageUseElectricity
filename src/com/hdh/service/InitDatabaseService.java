package com.hdh.service;

import com.hdh.database.*;
import com.hdh.model.*;

import java.util.Calendar;

public class InitDatabaseService {
    public static BranchDatabase branchDatabase = new BranchDatabase();
    public static FormUseDatabase formUseDatabase = new FormUseDatabase();

    public static CustomerDatabase customerDatabase = new CustomerDatabase();

    public static ContractDatabase contractDatabase = new ContractDatabase();

    public static ElectricMeterDatabase electricMeterDatabase = new ElectricMeterDatabase();


    public static void initData() {
        Calendar c1 = Calendar.getInstance();

        branchDatabase.getMaps().put(1, new Branch(1, "Branch 1", "Thủ Đức"));
        branchDatabase.getMaps().put(2, new Branch(2, "Branch 2", "Quận 12"));
        branchDatabase.getMaps().put(3, new Branch(3, "Branch 3", "Quận Phú Nhuận"));

        formUseDatabase.getMaps().put(1, new FormUse(1, "HouseHold", 100000));
        formUseDatabase.getMaps().put(2, new FormUse(2, "Enterprise", 150000));

        customerDatabase.getMaps().put(1, new HouseHold(1, "Hùng", "Thủ Đức", "0962357623"));
        customerDatabase.getMaps().put(2, new Enterprise(2, "Đức", "Quận 12", "01236659181"));

        contractDatabase.getMaps().put(1, new Contract(1, "Sign contract times 1", c1.getTime(), (Branch) branchDatabase.getMaps().get(1),
                (Customer) customerDatabase.getMaps().get(1), (FormUse) formUseDatabase.getMaps().get(1)));
        contractDatabase.getMaps().put(2, new Contract(2, "Sign contract times 2", c1.getTime(), (Branch) branchDatabase.getMaps().get(2),
                (Customer) customerDatabase.getMaps().get(2), (FormUse) formUseDatabase.getMaps().get(2)));

    }

}
