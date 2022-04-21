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

}
