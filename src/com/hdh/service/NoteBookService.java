package com.hdh.service;

import com.hdh.model.*;

import java.util.*;

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
//        dateWrite.setMonth(dateWrite.getMonth() + 1);

        int month = dateWrite.getMonth() + 1;
        int year = dateWrite.getYear() + 1900;
        NoteBook noteBookCheck = noteBookFindMonthYear(electricMeter, month, year); /// để test, sau month - 1

        System.out.print("Request enter index of electric meter: ");
        double indexElectric = scanner.nextDouble();

        if (noteBookCheck != null) {
            while (indexElectric < noteBookCheck.getIndex()) {
                System.out.print("Request to re-enter the index of electric: ");
                indexElectric = scanner.nextInt();
            }
        }
        dateWrite.setMonth(dateWrite.getMonth() + 1);  /// để test, sau comment

        NoteBook noteBookExist = checkExistNoteBook(electricMeter);

        if (noteBookExist == null) {
            NoteBook noteBook = new NoteBook(indexElectric, electricMeter, dateWrite);
            InitDatabaseService.noteBookDatabase.createNoteBook(noteBook);
        } else {
            noteBookExist.setIndex(indexElectric);
            noteBookExist.setDateWrite(dateWrite);
            int pos = InitDatabaseService.noteBookDatabase.getListNoteBook().indexOf(noteBookExist);
            InitDatabaseService.noteBookDatabase.getListNoteBook().set(pos, noteBookExist);
        }
    }

    public void updateNoteBook() {
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

        System.out.println("Request enter month: ");
        int month = scanner.nextInt();
        System.out.println("Request enter year: ");
        int year = scanner.nextInt();


        NoteBook noteBookUpdate = null;

        for (NoteBook noteBook : InitDatabaseService.noteBookDatabase.getListNoteBook()) {
            if (noteBook.getDateWrite().getMonth() + 1 == month && noteBook.getDateWrite().getYear() + 1900 == year && noteBook.getElectricMeter().equals(electricMeter)) {
                noteBookUpdate = noteBook;
            }
        }
        if (noteBookUpdate == null) {
            System.out.println("Not found notebook");
        } else {
            System.out.println("Value of notebook before update: " + noteBookUpdate.toString());
            System.out.println("Enter value index if you want update or enter -1 if you want to skip: ");
            int select = scanner.nextInt();
            if (select != -1) {
                try {
                    int pos = InitDatabaseService.noteBookDatabase.getListNoteBook().indexOf(noteBookUpdate);
                    noteBookUpdate.setIndex(select);
                    noteBookUpdate.setDateWrite(Calendar.getInstance().getTime());
                    InitDatabaseService.noteBookDatabase.getListNoteBook().set(pos, noteBookUpdate);
                    System.out.println("Update Success");
                    System.out.println("Value of notebook after update: ");
                    System.out.println(noteBookUpdate.toString());
                } catch (Exception e) {
                    System.out.println("Update failed");
                }
            }
        }
    }

    public void deleteRecordNoteBook() {
        Scanner scanner = new Scanner(System.in);
        ElectricMeter electricMeter;

        System.out.println("Request enter id of electric meter");
        int idElectric = scanner.nextInt();
        do {
            if (idElectric == -1) {
                return;
            }
            electricMeter = (ElectricMeter) InitDatabaseService.electricMeterDatabase.findById(idElectric);
            if (electricMeter == null) {
                System.out.println("No exists electric meter with id: " + idElectric);
                System.out.println("Request enter id of electric meter or -1 to exit: ");
                idElectric = scanner.nextInt();
            }
        } while (electricMeter == null);

        System.out.println("Request enter month: ");
        int month = scanner.nextInt();
        System.out.println("Request enter year: ");
        int year = scanner.nextInt();
        System.out.println("Request enter index of electric meter: ");
        double indexElectric = scanner.nextDouble();
        try {
            for (NoteBook noteBook : InitDatabaseService.noteBookDatabase.getListNoteBook()) {
                if (noteBook.getDateWrite().getMonth() + 1 == month && noteBook.getDateWrite().getYear() + 1900 == year && noteBook.getIndex() == indexElectric
                        && noteBook.getElectricMeter().equals(electricMeter)) {
                    InitDatabaseService.noteBookDatabase.getListNoteBook().remove(noteBook);
                    System.out.println("Delete success");
                    return;
                }
            }
            System.out.println("Not found record of notebook");
        } catch (Exception e) {
            System.out.println("Delete failed");
        }
    }

    public static void autoAdd(ElectricMeter electricMeter) {
        Calendar c1 = Calendar.getInstance();
        Date dateWrite = c1.getTime();
//        System.out.print("Request enter index of electric meter: ");
        NoteBook noteBook = new NoteBook(0, electricMeter, dateWrite);
        InitDatabaseService.noteBookDatabase.createNoteBook(noteBook);
    }

    public NoteBook noteBookFindMonthYear(ElectricMeter electricMeter, int month, int year) {
        for (NoteBook noteBook : InitDatabaseService.noteBookDatabase.getListNoteBook()) {
            if (noteBook.getElectricMeter().equals(electricMeter) && month == (noteBook.getDateWrite().getMonth() + 1) && year == (noteBook.getDateWrite().getYear() + 1900)) {
                return noteBook;
            }
        }
        return null;
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

    public NoteBook checkExistNoteBook(ElectricMeter electricMeter) {
        for (NoteBook noteBook : InitDatabaseService.noteBookDatabase.getListNoteBook()) {
            int monthNotebook = noteBook.getDateWrite().getMonth() + 1;
            int yearNoteBook = noteBook.getDateWrite().getYear() + 1900;

            int monthCheck = Calendar.getInstance().getTime().getMonth() + 2;/// Để check
            int yearCheck = Calendar.getInstance().getTime().getYear() + 1900;

            if (noteBook.getElectricMeter().equals(electricMeter) && monthNotebook == monthCheck && yearNoteBook == yearCheck) {
                return noteBook;
            }
        }
        return null;
    }

}
