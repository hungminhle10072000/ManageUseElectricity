package com.hdh.service;

import com.hdh.model.FormUse;

import java.util.Scanner;

public class FormUseService {

    Scanner scanner = new Scanner(System.in);

    public FormUse createObjectFormUse() {
        FormUse formUseNew = new FormUse();
        formUseNew.inputFormUse();
        return formUseNew;
    }

    public void deleteFormUseById() {
        System.out.print("Request enter id of form use want delete: ");
        int idDelete = scanner.nextInt();
        InitDatabaseService.formUseDatabase.deleteById(idDelete);
    }
}
