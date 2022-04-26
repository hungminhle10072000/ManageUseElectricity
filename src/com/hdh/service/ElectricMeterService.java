package com.hdh.service;

import com.hdh.model.Contract;
import com.hdh.model.ElectricMeter;

import java.util.Scanner;

public class ElectricMeterService {

    Scanner scanner = new Scanner(System.in);

    public void addElectricMeter() {
        try {
            System.out.print("Request enter id of contract: ");
            int idContract = scanner.nextInt();
            Contract contract;
            do {
                contract = (Contract) InitDatabaseService.contractDatabase.findById(idContract);
                if (contract == null) {
                    System.out.println("No exists contract with id: " + idContract);
                    System.out.print("Request enter id of contract: ");
                    idContract = scanner.nextInt();
                } else {
                    System.out.println("Request enter typeElectricMeter: ");
                    scanner.nextLine();
                    String typeElectricMeter = scanner.nextLine();
                    ElectricMeter electricMeterAdd = new ElectricMeter(typeElectricMeter, contract);
                    InitDatabaseService.electricMeterDatabase.create(electricMeterAdd);
                    NoteBookService.autoAdd(electricMeterAdd);
                    System.out.println("Add electric meter success");
                }
            } while (contract == null);

        } catch (Exception e) {
            System.out.println("Add Electric Meter failed");
        }
    }

    public void findInfoElectricMeter() {
        try {
            System.out.print("Request enter id of electric meter you want find: ");
            int id = scanner.nextInt();
            ElectricMeter electricMeter = (ElectricMeter) InitDatabaseService.electricMeterDatabase.findById(id);
            if (electricMeter == null) {
                System.out.println("Not found electric meter with id: " + id);
            } else {
                System.out.println("Information of electric meter: " + electricMeter);
            }
        } catch (Exception e) {
            System.out.println("Find failed");
        }
    }

    public void getAllElecticMeter() {
        InitDatabaseService.electricMeterDatabase.getMaps().forEach((key, value) -> System.out.println(value.toString()));
    }

    public void deleteElectricMeter() {
        try {
            System.out.print("Request enter id of electric meter want delete: ");
            int idDelete = scanner.nextInt();
            scanner.nextLine();
            ElectricMeter electricMeter = (ElectricMeter) InitDatabaseService.electricMeterDatabase.findById(idDelete);
            if (electricMeter != null) {
                InitDatabaseService.electricMeterDatabase.deleteById(idDelete);
                System.out.println("Delete success");
            } else {
                System.out.println("Not found electric meter with id: " + idDelete);
            }
        } catch (Exception e) {
            System.out.println("Delete failed");
        }
    }

    public void updateElectricMeter() {
        System.out.println("Enter id you want update: ");
        int id = scanner.nextInt();
        ElectricMeter electricMeter = (ElectricMeter) InitDatabaseService.electricMeterDatabase.findById(id);
        if (electricMeter == null) {
            System.out.println("No exits electric meter with id: " + id);
        } else {
            System.out.println("Value of electric meter before update: ");
            System.out.println(electricMeter);

            System.out.println("Input the data of typeElectricMeter if you want to update or enter if you want to skip: ");
            scanner.nextLine();
            String typeElectricMeter = scanner.nextLine();

            System.out.println("Input the data of idContract if you want to update or input [-1] if you want to skip: ");
            int idContract = scanner.nextInt();
            Contract contract = null;
            if (id != -1) {
                do {
                    if (idContract == -1) {
                        break;
                    }
                    contract = (Contract) InitDatabaseService.contractDatabase.findById(idContract);
                    if (contract == null) {
                        System.out.println("No exists contract with id: " + idContract);
                        System.out.println("Input the data of idContract if you want to update or input [-1] if you want to skip: ");
                        idContract = scanner.nextInt();
                    }
                } while (contract == null);
            }


            if (!typeElectricMeter.isEmpty()) electricMeter.setTypeElectricMeter(typeElectricMeter);
            if (!(contract == null)) electricMeter.setContract(contract);

            InitDatabaseService.electricMeterDatabase.getMaps().put(id, electricMeter);
            System.out.println("Value of electric meter after update: ");
            System.out.println(electricMeter);

        }
    }

    public void findElectricMeterByType() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Request enter type of ElectricMeter you want find: ");
            String typeElectric = scanner.nextLine();
            InitDatabaseService.electricMeterDatabase.getMaps().forEach((key, value) -> {
                ElectricMeter electricMeter = (ElectricMeter) value;
                if (electricMeter.getTypeElectricMeter().equals(typeElectric)) System.out.println(electricMeter);
            });
        } catch (Exception e) {
            System.out.println("Find failed");
        }
    }

}
