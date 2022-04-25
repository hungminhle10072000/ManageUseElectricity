package com.hdh.service;

import com.hdh.model.Customer;
import com.hdh.model.ElectricMeter;
import com.hdh.model.Invoice;
import com.hdh.model.NoteBook;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class InvoiceService {

    public NoteBookService noteBookService = new NoteBookService();

    public void issueAnInvoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Request enter month: ");
        int month = scanner.nextInt();
        System.out.print("Request enter year: ");
        int year = scanner.nextInt();
        InitDatabaseService.electricMeterDatabase.getMaps().forEach((key, electric) -> {
                    Invoice invoiceAdd = new Invoice();
                    NoteBook noteBookCurrent = noteBookService.noteBookFindMonthYear((ElectricMeter) electric, month + 1, year);
                    NoteBook noteBookLast = noteBookService.noteBookFindMonthYear((ElectricMeter) electric, month, year);
                    if (noteBookCurrent != null && noteBookLast != null) {
                        double unitPrice = noteBookCurrent.getElectricMeter().getContract().getFormUse().getUnitPrice();
                        int idInvoiceCheck = checkExistInvoice(noteBookLast, (ElectricMeter) electric);
                        if (idInvoiceCheck != -1) {
                            Invoice invoiceUpdate = (Invoice) InitDatabaseService.invoiceDatabase.findById(idInvoiceCheck);
                            invoiceUpdate.setDateEnd(noteBookCurrent.getDateWrite());
                            invoiceUpdate.setTotalMoney((noteBookCurrent.getIndex() - noteBookLast.getIndex()) * unitPrice);
                            invoiceUpdate.setStatus(false);
                            InitDatabaseService.invoiceDatabase.getMaps().put(idInvoiceCheck, invoiceUpdate);
                        } else {
                            invoiceAdd.setDateFrom(noteBookLast.getDateWrite());
                            invoiceAdd.setDateEnd(noteBookCurrent.getDateWrite());
                            invoiceAdd.setStatus(false);
                            invoiceAdd.setNoteBook(noteBookCurrent);
                            invoiceAdd.setTotalMoney((noteBookCurrent.getIndex() - noteBookLast.getIndex()) * unitPrice);
                            InitDatabaseService.invoiceDatabase.create(invoiceAdd);
                        }
                    }
                }
        );
    }

    public int checkExistInvoice(NoteBook noteBookLast, ElectricMeter electricMeter) {
        System.out.println(InitDatabaseService.invoiceDatabase.getMaps().toString());
        Set<Integer> keySet = InitDatabaseService.invoiceDatabase.getMaps().keySet();
        for (Integer key : keySet) {
            Invoice invoice = (Invoice) InitDatabaseService.invoiceDatabase.getMaps().get(key);
            if (invoice.getDateFrom().equals(noteBookLast.getDateWrite()) && invoice.getNoteBook().getElectricMeter().equals(electricMeter)) {
                return key;
            }
        }
        return -1;
    }

    public void getAllInvoiceMonthYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Request enter month: ");
        int month = scanner.nextInt();
        System.out.print("Request enter year: ");
        int year = scanner.nextInt();
        InitDatabaseService.invoiceDatabase.getMaps().forEach((key, value) -> {
            Invoice invoice = (Invoice) value;
            if ((invoice.getDateFrom().getMonth() + 1) == month && (invoice.getDateFrom().getYear() + 1900) == year) {
                System.out.println(invoice.toString());
            }
        });
    }

    public void updateStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Request enter id of invoice: ");
        int idInvoice = scanner.nextInt();
        Invoice invoiceUpdate = (Invoice) InitDatabaseService.invoiceDatabase.findById(idInvoice);
        if (invoiceUpdate != null) {
            System.out.println("Input 1 if paid or -1 if unpaid");
            int check = scanner.nextInt();
            if (check == 1) invoiceUpdate.setStatus(true);
            else invoiceUpdate.setStatus(false);
            InitDatabaseService.invoiceDatabase.getMaps().put(idInvoice, invoiceUpdate);
        } else {
            System.out.println("Not found invoice with id: " + idInvoice);
        }
    }

    public void findInvoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Request enter id of customer: ");
        int idCustomer = scanner.nextInt();
        System.out.print("Request enter month: ");
        int month = scanner.nextInt();
        System.out.print("Request enter year: ");
        int year = scanner.nextInt();
        Customer customer = (Customer) InitDatabaseService.customerDatabase.findById(idCustomer);
        InitDatabaseService.invoiceDatabase.getMaps().forEach((key, value) -> {
            Invoice invoice = (Invoice) value;
            if (invoice.getDateFrom().getMonth() + 1 == month && invoice.getDateFrom().getYear() + 1900 == year
                    && invoice.getNoteBook().getElectricMeter().getContract().getCustomer().equals(customer)) {
                System.out.println(invoice);
            }
        });
    }

    public void deleteInvoice() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Request enter id of invoice: ");
        int idInvoice = scanner.nextInt();
        if (InitDatabaseService.invoiceDatabase.findById(idInvoice) == null)
            System.out.println("No found invoice with id: " + idInvoice);
        else {
            try {
                InitDatabaseService.invoiceDatabase.deleteById(idInvoice);
                System.out.println("Delete success");
            } catch (Exception e) {
                System.out.println("Delete invoice failed");
            }
        }

    }
}
