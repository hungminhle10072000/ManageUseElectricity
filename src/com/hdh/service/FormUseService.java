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

    public void updateFormUse() {
        System.out.println("Enter id of form use you want update: ");
        int id = scanner.nextInt();
        FormUse formUseUpdate = (FormUse) InitDatabaseService.formUseDatabase.findById(id);
        if(formUseUpdate == null){
            System.out.println("No form use with id: " + id);
        } else  {
            System.out.println("Value of form use befor update: ");
            System.out.println(formUseUpdate);
            System.out.println("Input the data if you want to update, enter or input value 0 if you want to skip: ");
            System.out.println("Enter value of nameForm");
            scanner.nextLine();
            String nameForm = scanner.nextLine();
            System.out.println("Enter value of unitPrice: ");
            Double unitPrice = scanner.nextDouble();
            System.out.println(unitPrice);
            if(!nameForm.isEmpty()) formUseUpdate.setNameForm(nameForm);
            if(!unitPrice.equals(0.0)) formUseUpdate.setUnitPrice(unitPrice);
            InitDatabaseService.formUseDatabase.getMaps().put(id, formUseUpdate);
            System.out.println("Value of form use after update: ");
            System.out.println(formUseUpdate);
        }
    }
}
