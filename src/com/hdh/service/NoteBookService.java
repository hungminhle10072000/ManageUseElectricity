package com.hdh.service;

import com.hdh.model.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class NoteBookService {


    public void getAllRecordNoteBook() {
        for (NoteBook noteBook : InitDatabaseService.noteBookDatabase.getListNoteBook()) {
            System.out.println(noteBook.toString());
        }
    }

    public void addNoteBook() {
        Scanner scanner = new Scanner(System.in);
        ElectricMeter electricMeter;

        System.out.println("Request enter id of electric meter");
        int idElectric = scanner.nextInt();

        do {
            electricMeter = (ElectricMeter) InitDatabaseService.electricMeterDatabase.findById(idElectric);
            if (electricMeter == null) {
                System.out.println("No exists electric meter with id: " + idElectric);
                System.out.println("Request enter id of electric meter");
                idElectric = scanner.nextInt();
            }
        } while (electricMeter == null);

        Calendar c1 = Calendar.getInstance();
        Date dateWrite = c1.getTime();
        System.out.print("Request enter index of electric meter: ");
        double indexElectric = scanner.nextDouble();

        NoteBook noteBook = new NoteBook(indexElectric, electricMeter, dateWrite);
        InitDatabaseService.noteBookDatabase.createNoteBook(noteBook);

    }

    public static void autoAdd(ElectricMeter electricMeter) {
        Calendar c1 = Calendar.getInstance();
        Date dateWrite = c1.getTime();
        System.out.print("Request enter index of electric meter: ");
        NoteBook noteBook = new NoteBook(0, electricMeter, dateWrite);
        InitDatabaseService.noteBookDatabase.createNoteBook(noteBook);
    }

    public void findNoteBook() {
        boolean check = false;
        Scanner scanner = new Scanner(System.in);
        Customer customer;

        System.out.println("Request enter month and year you want find");
        System.out.print("Month: ");
        int monthFind = scanner.nextInt();
        System.out.print("Year: ");
        scanner.nextLine();
        int yearFind = scanner.nextInt();
        System.out.println("Request enter id of customer: ");
        int idCustomer = scanner.nextInt();

        do {
            customer = (Customer) InitDatabaseService.customerDatabase.findById(idCustomer);
            if (customer == null) {
                System.out.println("No exists customer with id: " + idCustomer);
                System.out.println("Request enter id of customer: ");
                idCustomer = scanner.nextInt();
            }
        } while (customer == null);

        for (NoteBook noteBook : InitDatabaseService.noteBookDatabase.getListNoteBook()) {
            int monthValue = noteBook.getDateWrite().getMonth() + 1;
            int yearValue = noteBook.getDateWrite().getYear() + 1900;
            Customer customerValue = noteBook.getElectricMeter().getContract().getCustomer();
            if (customer.equals(customerValue) && monthFind == monthValue && yearFind == yearValue) {
                check = true;
                System.out.println(noteBook);
            }
        }
        if (!check) {
            System.out.println("Not found record!!!");
        }

    }

}
