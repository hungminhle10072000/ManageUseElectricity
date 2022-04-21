package com.hdh.service;

import com.hdh.model.Customer;
import com.hdh.model.Enterprise;
import com.hdh.model.HouseHold;

import java.util.Scanner;

public class CustomerService {

    Scanner scanner = new Scanner(System.in);

    public void addCustomer() {
        Customer customerAdd;
        System.out.print("Select customer type (1 - household, 2 - enterprise): ");
        int choose = scanner.nextInt();
        scanner.nextLine();
        if (choose == 1) {
            System.out.println("Request enter name: ");
            String name = scanner.nextLine();
            System.out.println("Request enter address: ");
            String address = scanner.nextLine();
            System.out.println("Request enter phoneNumber: ");
            String phoneNumber = scanner.nextLine();
            customerAdd = new HouseHold(name, address, phoneNumber);
            InitDatabaseService.customerDatabase.create(customerAdd);
        } else if (choose == 2) {
            System.out.println("Request enter name: ");
            String name = scanner.nextLine();
            System.out.println("Request enter address: ");
            String address = scanner.nextLine();
            System.out.println("Request enter phoneNumber: ");
            String phoneNumber = scanner.nextLine();
            customerAdd = new Enterprise(name, address, phoneNumber);
            InitDatabaseService.customerDatabase.create(customerAdd);
        } else {
            System.out.println("Unsuccessful !!! You chose the wrong one.");
        }
    }

    public void getAllCustomer() {
        InitDatabaseService.customerDatabase.getMaps().forEach((key, value) -> System.out.println(value.toString()));
    }

    public void deleteCustomerById() {
        try {
            System.out.print("Request enter id of customer want delete: ");
            int idDelete = scanner.nextInt();
            Customer customerDelete = (Customer) InitDatabaseService.customerDatabase.findById(idDelete);
            if (customerDelete != null) {
                InitDatabaseService.customerDatabase.deleteById(idDelete);
                System.out.println("Delete success");
            } else {
                System.out.println("Not found customer with id: " + idDelete);
            }
        } catch (Exception e) {
            System.out.println("Delete failed");
        }
    }

    public void checkInfoCustomer() {
        try {
            System.out.println("Request enter id of customer yow want find: ");
            int idCustomer = scanner.nextInt();
            Customer customer = (Customer) InitDatabaseService.customerDatabase.findById(idCustomer);
            if (customer == null) {
                System.out.println("Not found customer with id: " + idCustomer);
            } else {
                System.out.println("Information of customer: " + customer);
            }
        } catch (Exception e) {
            System.out.println("Find failed");
        }
    }

    public void updateCustomer() {
        System.out.println("Enter id of customer want update: ");
        int id = scanner.nextInt();
        Customer customerUpdate = (Customer) InitDatabaseService.customerDatabase.findById(id);
        if (customerUpdate == null) {
            System.out.println("No found customer with id: " + id);
        } else {
            System.out.println("Value of customer before update: ");
            System.out.println(customerUpdate);
            System.out.println("Input the data if you want to update, input value 0 or enter if you want to skip: ");
            System.out.println("Enter value of name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.println("Enter value of address: ");
            String address = scanner.nextLine();
            System.out.println("Enter value of phoneNumber: ");
            String phoneNumber = scanner.nextLine();
            if (!name.isEmpty()) customerUpdate.setName(name);
            if (!address.isEmpty()) customerUpdate.setAddress(address);
            if (!phoneNumber.isEmpty()) customerUpdate.setPhoneNumber(phoneNumber);
            InitDatabaseService.customerDatabase.getMaps().put(id, customerUpdate);
            System.out.println("Value of customer after update: ");
            System.out.println(customerUpdate);
        }
    }

}
