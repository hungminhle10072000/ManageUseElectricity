package com.hdh.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Branch {

    private int id;
    private String nameBranch;
    private String address;

    private List<Contract> contractList;

    public Branch(int id, String nameBranch, String address, List<Contract> contractList) {
        this.id = id;
        this.nameBranch = nameBranch;
        this.address = address;
        this.contractList = contractList;
    }

    public Branch(String nameBranch, String address) {

        this.nameBranch = nameBranch;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
