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

            System.out.print("Request enter typeElectricMeter: ");
            scanner.nextLine();
            String typeElectricMeter = scanner.nextLine();

            Contract contract = (Contract) InitDatabaseService.contractDatabase.findById(idContract);


            ElectricMeter electricMeterAdd = new ElectricMeter(typeElectricMeter, contract);
            InitDatabaseService.electricMeterDatabase.create(electricMeterAdd);
            System.out.println("Add electric meter success");
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

}
