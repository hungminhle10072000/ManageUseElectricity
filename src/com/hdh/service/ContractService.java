package com.hdh.service;

import com.hdh.model.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ContractService {
    Scanner scanner = new Scanner(System.in);

    public void addContract() {
        try {
            Customer customer;
            FormUse formUse;
            Branch branch;

            System.out.print("Request enter id of customer: ");
            int idCustomer = scanner.nextInt();

            System.out.print("Request enter id of form use: ");
            int idFormUse = scanner.nextInt();

            System.out.print("Request enter id of Branch: ");
            int idBranch = scanner.nextInt();

            do {
                customer = (Customer) InitDatabaseService.customerDatabase.findById(idCustomer);
                if (customer == null) {
                    System.out.println("No exists customer with id: " + idCustomer);
                    System.out.print("Request enter id of customer: ");
                    idCustomer = scanner.nextInt();
                }
                formUse = (FormUse) InitDatabaseService.formUseDatabase.findById(idFormUse);
                if (formUse == null) {
                    System.out.println("No exists form use with id: " + idFormUse);
                    System.out.print("Request enter id of form use: ");
                    idFormUse = scanner.nextInt();
                }
                branch = (Branch) InitDatabaseService.branchDatabase.findById(idBranch);
                if (branch == null) {
                    System.out.println("No exists branch with id: " + idBranch);
                    System.out.print("Request enter id of Branch: ");
                    idBranch = scanner.nextInt();
                }
            } while (customer == null || formUse == null || branch == null);


            Calendar c1 = Calendar.getInstance();
            Date dateSign = c1.getTime();
            System.out.println("Request input content of tract: ");
            scanner.nextLine();
            String context = scanner.nextLine();

            Contract contractAdd = new Contract(context, dateSign, branch, customer, formUse);
            InitDatabaseService.contractDatabase.create(contractAdd);
            System.out.println("Sign Contract Success");

        } catch (Exception e) {
            System.out.println("Sign Contract Failed");
        }
    }

    public void updateContract() {
        try {
            System.out.print("Request enter id of Contract you want update: ");
            int idUpdate = scanner.nextInt();
            Contract contract = (Contract) InitDatabaseService.contractDatabase.findById(idUpdate);
            if (contract == null) {
                System.out.println("Not found contract with id: " + idUpdate);
            } else {
                System.out.println("Value of Contract before update: ");
                System.out.println(contract);

                System.out.println("Input the data of content if you want to update or enter if you want to skip: ");
                scanner.nextLine();
                String content = scanner.nextLine();

                System.out.println("Input the data of id customer if you want to update or input -1 if you want to skip: ");
                int idCustomer = scanner.nextInt();
                System.out.println("Input the data of form use if want to update or input -1 if you want to skip: ");
                int idFormUse = scanner.nextInt();
                System.out.println("Input the data of branch if want to update or input -1 if you want to skip: ");
                int idBranch = scanner.nextInt();


                Customer customer = null;
                FormUse formUse = null;
                Branch branch = null;

                if (idCustomer != -1) {
                    do {
                        if (idCustomer == -1) {
                            break;
                        }
                        customer = (Customer) InitDatabaseService.customerDatabase.findById(idCustomer);
                        if (customer == null) {
                            System.out.println("No exists customer with id: " + idCustomer);
                            System.out.println("Input the data of id customer if you want to update or input -1 if you want to skip: ");
                            idCustomer = scanner.nextInt();
                        }
                    } while (customer == null);
                }

                if (idFormUse != -1) {
                    do {
                        if (idFormUse == -1) {
                            break;
                        }
                        formUse = (FormUse) InitDatabaseService.formUseDatabase.findById(idFormUse);
                        if (formUse == null) {
                            System.out.println("No exists form use with id: " + idFormUse);
                            System.out.println("Input the data of form use if want to update or input -1 if you want to skip: ");
                            idFormUse = scanner.nextInt();
                        }
                    } while (formUse == null);
                }

                if (idBranch != -1) {
                    do {
                        if (idBranch == -1) {
                            break;
                        }
                        branch = (Branch) InitDatabaseService.branchDatabase.findById(idBranch);
                        if (branch == null) {
                            System.out.println("No exists branch with id: " + idBranch);
                            System.out.println("Input the data of branch if want to update or input -1 if you want to skip: ");
                            idBranch = scanner.nextInt();
                        }
                    } while (branch == null);
                }

                if (!content.isEmpty()) contract.setContent(content);
                if (!(customer == null)) contract.setCustomer(customer);
                if (!(formUse == null)) contract.setFormUse(formUse);
                if (!(branch == null)) contract.setBranch(branch);

                InitDatabaseService.contractDatabase.getMaps().put(idUpdate, contract);
                System.out.println("Value of contract after update: ");
                System.out.println(contract);
            }


        } catch (Exception e) {
            System.out.println("Update failed");
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

    public void deleteContract() {
        try {
            System.out.print("Request enter id of contract want delete: ");
            int idDelete = scanner.nextInt();
            Contract contractDelete = (Contract) InitDatabaseService.contractDatabase.findById(idDelete);
            if (contractDelete != null) {
                InitDatabaseService.contractDatabase.deleteById(idDelete);
                System.out.println("Delete success");
            } else {
                System.out.println("Not found contract with id: " + idDelete);
            }
        } catch (Exception e) {
            System.out.println("Delete failed");
        }
    }

}
