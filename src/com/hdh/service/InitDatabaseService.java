package com.hdh.service;

import com.hdh.database.BranchDatabase;
import com.hdh.database.ContractDatabase;
import com.hdh.database.CustomerDatabase;
import com.hdh.database.FormUseDatabase;
import com.hdh.model.*;

public class InitDatabaseService {
    public static BranchDatabase branchDatabase = new BranchDatabase();
    public static FormUseDatabase formUseDatabase = new FormUseDatabase();

    public static CustomerDatabase customerDatabase = new CustomerDatabase();

    public static ContractDatabase contractDatabase = new ContractDatabase();


    public static void initData() {
        branchDatabase.getMaps().put(1, new Branch(1, "Branch 1", "Thủ Đức"));
        branchDatabase.getMaps().put(2, new Branch(2, "Branch 2", "Quận 12"));
        branchDatabase.getMaps().put(3, new Branch(3, "Branch 3", "Quận Phú Nhuận"));

        formUseDatabase.getMaps().put(1, new FormUse(1, "HouseHold", 100000));
        formUseDatabase.getMaps().put(2, new FormUse(2, "Enterprise", 150000));

        customerDatabase.getMaps().put(1, new HouseHold(1, "Hùng", "Thủ Đức", "0962357623"));
        customerDatabase.getMaps().put(2, new Enterprise(2, "Đức", "Quận 12", "01236659181"));
    }

}
