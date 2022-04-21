package com.hdh.service;

import com.hdh.model.Branch;

import java.util.Scanner;

public class BranchService {

    Scanner scanner = new Scanner(System.in);

    public Branch createObjectBranch() {
        Branch branchNew = new Branch();
        System.out.println("Request to enter branch information!!!");
        branchNew.inputInfoBranch();
        return branchNew;
    }

    public void deleteBranchById() {
        System.out.print("Request enter id of branch want delete: ");
        int idDelete = scanner.nextInt();
        InitDatabaseService.branchDatabase.deleteById(idDelete);
    }

    public void updateBranch() {
        System.out.println("Enter id you want update: ");
        int id = scanner.nextInt();
        Branch branchUpdate = (Branch) InitDatabaseService.branchDatabase.findById(id);
        if (branchUpdate == null) {
            System.out.println("No branch with id: " + id);
        } else {
            System.out.println("Value of branch before update: ");
            System.out.println(branchUpdate);
            System.out.println("Input the data if you want to update or enter if you want to skip: ");
            System.out.println("Enter value of nameBranch: ");
            scanner.nextLine();
            String nameBranch = scanner.nextLine();
            System.out.println("Enter value of address: ");
            String address = scanner.nextLine();
            if (!nameBranch.isEmpty()) branchUpdate.setNameBranch(nameBranch);
            if (!address.isEmpty()) branchUpdate.setAddress(address);
            InitDatabaseService.branchDatabase.getMaps().put(id, branchUpdate);
            System.out.println("Value of branch after update: ");
            System.out.println(branchUpdate);
        }
    }

    public void findBranchbyId() {
        try {
            System.out.println("Request enter id of branch yow want find: ");
            int id = scanner.nextInt();
            Branch branch = (Branch) InitDatabaseService.branchDatabase.findById(id);
            if (branch == null) {
                System.out.println("Not found branch with id: " + id);
            } else {
                System.out.println("Information of branch: " + branch);
            }
        } catch (Exception e) {
            System.out.println("Find failed");
        }
    }


}
