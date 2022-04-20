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
}
