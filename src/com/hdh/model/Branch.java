package com.hdh.model;

public class Branch {

    private long id;

    private String nameBranch;

    private String address;

    public Branch(long id, String nameBranch, String address) {
        this.id = id;
        this.nameBranch = nameBranch;
        this.address = address;
    }

    public Branch() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameBranch() {
        return nameBranch;
    }

    public void setNameBranch(String nameBranch) {
        this.nameBranch = nameBranch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
