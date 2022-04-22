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
        try {
            System.out.print("Request enter id of form use want delete: ");
            int idDelete = scanner.nextInt();
            FormUse formUseDelete = (FormUse) InitDatabaseService.formUseDatabase.findById(idDelete);
            if (formUseDelete != null) {
                InitDatabaseService.formUseDatabase.deleteById(idDelete);
                System.out.println("Delete success");
            } else {
                System.out.println("Not found form use with id: " + idDelete);
            }
        } catch (Exception e) {
            System.out.println("Delete failed");
        }
    }

    public void updateFormUse() {
        System.out.println("Enter id of form use you want update: ");
        int id = scanner.nextInt();
        FormUse formUseUpdate = (FormUse) InitDatabaseService.formUseDatabase.findById(id);
        if (formUseUpdate == null) {
            System.out.println("No form use with id: " + id);
        } else {
            System.out.println("Value of form use befor update: ");
            System.out.println(formUseUpdate);
            System.out.println("Input the data if you want to update, enter or input value 0 if you want to skip: ");
            System.out.println("Enter value of nameForm");
            scanner.nextLine();
            String nameForm = scanner.nextLine();
            System.out.println("Enter value of unitPrice: ");
            Double unitPrice = scanner.nextDouble();
            System.out.println(unitPrice);
            if (!nameForm.isEmpty()) formUseUpdate.setNameForm(nameForm);
            if (!unitPrice.equals(0.0)) formUseUpdate.setUnitPrice(unitPrice);
            InitDatabaseService.formUseDatabase.getMaps().put(id, formUseUpdate);
            System.out.println("Value of form use after update: ");
            System.out.println(formUseUpdate);
        }
    }

    public void findFormUse() {
        try {
            System.out.println("Request enter id of form use yow want find: ");
            int id = scanner.nextInt();
            FormUse formUse = (FormUse) InitDatabaseService.formUseDatabase.findById(id);
            if (formUse == null) {
                System.out.println("Not found form use with id: " + id);
            } else {
                System.out.println("Information of form use: " + formUse);
            }
        } catch (Exception e) {
            System.out.println("Find failed");
        }
    }


    public void findFormUseByNameForm() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Request enter name of form use you want find: ");
            String name = scanner.nextLine();
            InitDatabaseService.formUseDatabase.getMaps().forEach((key, value) -> {
                FormUse formUse = (FormUse) value;
                if (formUse.getNameForm().equals(name.trim())) System.out.println(formUse);
            });
        } catch (Exception e) {
            System.out.println("Find failed");
        }
    }

}
