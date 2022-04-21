package com.hdh.service;

import com.hdh.model.Branch;
import com.hdh.model.Contract;
import com.hdh.model.Customer;
import com.hdh.model.FormUse;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ContractService {
    Scanner scanner = new Scanner(System.in);

    public void addContract() {
        try {
            System.out.print("Request enter id of customer: ");
            int idCustomer = scanner.nextInt();

            System.out.print("Request enter id of form use: ");
            int idFormUse = scanner.nextInt();

            System.out.print("Request enter id of Branch: ");
            int idBranch = scanner.nextInt();

            System.out.println("Request input context of tract: ");
            scanner.nextLine();
            String context = scanner.nextLine();

            Calendar c1 = Calendar.getInstance();
            Date dateSign = c1.getTime();

            Customer customer = (Customer) InitDatabaseService.customerDatabase.findById(idCustomer);
            Branch branch = (Branch) InitDatabaseService.branchDatabase.findById(idBranch);
            FormUse formUse = (FormUse) InitDatabaseService.formUseDatabase.findById(idFormUse);

            Contract contractAdd = new Contract(context, dateSign, branch, customer, formUse);
            InitDatabaseService.contractDatabase.create(contractAdd);
            System.out.println("Sign Contract Success");
        } catch (Exception e) {
            System.out.println("Sign Contract Failed");
        }
    }

    public void getAllContract() {
        InitDatabaseService.contractDatabase.getMaps().forEach((key, value) -> System.out.println(value.toString()));
    }

    public void findInfoContract() {
        try {
            System.out.print("Request enter id of contract yow want find: ");
            int id = scanner.nextInt();
            Contract contract = (Contract) InitDatabaseService.contractDatabase.findById(id);
            if (contract == null) {
                System.out.println("Not found contract with id: " + id);
            } else {
                System.out.println("Information of contract: " + contract);
            }
        } catch (Exception e) {
            System.out.println("Find failed");
        }
    }

}
