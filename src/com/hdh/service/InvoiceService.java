package com.hdh.service;

import com.hdh.model.Customer;
import com.hdh.model.ElectricMeter;
import com.hdh.model.Invoice;
import com.hdh.model.NoteBook;

import java.util.Scanner;

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
                invoiceAdd.setDateFrom(noteBookLast.getDateWrite());
                invoiceAdd.setDateEnd(noteBookCurrent.getDateWrite());
                invoiceAdd.setStatus(false);
                invoiceAdd.setNoteBook(noteBookCurrent);
                invoiceAdd.setTotalMoney((noteBookCurrent.getIndex() - noteBookLast.getIndex()) * unitPrice);
                InitDatabaseService.invoiceDatabase.create(invoiceAdd);
            }
        });
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
        System.out.println("Input 1 if paid or -1 if unpaid");
        int check = scanner.nextInt();
        Invoice invoiceUpdate = (Invoice) InitDatabaseService.invoiceDatabase.findById(idInvoice);
        if (idInvoice == 1) invoiceUpdate.setStatus(true);
        else invoiceUpdate.setStatus(false);
        InitDatabaseService.invoiceDatabase.getMaps().put(idInvoice, invoiceUpdate);
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
}
