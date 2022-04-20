package com.hdh.model;

import java.util.Scanner;

public class FormUse implements BaseModel{

    private int id;

    private String nameForm;

    private double unitPrice;

    public FormUse(int id, String nameForm, double unitPrice) {
        this.id = id;
        this.nameForm = nameForm;
        this.unitPrice = unitPrice;
    }

    public FormUse() {
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "FormUse{" +
                "id=" + id +
                ", nameForm='" + nameForm + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }

    public void inputFormUse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Request enter nameForm: ");
        nameForm = scanner.nextLine();
        System.out.println("Request enter unitPrice: ");
        unitPrice = scanner.nextDouble();
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameForm() {
        return nameForm;
    }

    public void setNameForm(String nameForm) {
        this.nameForm = nameForm;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
