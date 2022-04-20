package com.hdh.model;

import java.util.Date;

public class Contract {
    private long id;

    private String content;

    private Date dateSign;

    private Branch branch;

    private Customer customer;

    private FormUse formUse;

    public Contract(long id, String content, Date dateSign, Branch branch, Customer customer, FormUse formUse) {
        this.id = id;
        this.content = content;
        this.dateSign = dateSign;
        this.branch = branch;
        this.customer = customer;
        this.formUse = formUse;
    }

    public Contract() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateSign() {
        return dateSign;
    }

    public void setDateSign(Date dateSign) {
        this.dateSign = dateSign;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public FormUse getFormUse() {
        return formUse;
    }

    public void setFormUse(FormUse formUse) {
        this.formUse = formUse;
    }
}
