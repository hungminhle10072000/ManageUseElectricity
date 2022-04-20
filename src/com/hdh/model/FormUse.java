package com.hdh.model;

public class FormUse {
    private String nameForm;

    private double unitPrice;

    public FormUse(String nameForm, double unitPrice) {
        this.nameForm = nameForm;
        this.unitPrice = unitPrice;
    }

    public FormUse() {
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
