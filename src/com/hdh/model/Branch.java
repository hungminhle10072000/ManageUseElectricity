package com.hdh.model;
import java.util.Scanner;

public class Branch implements BaseModel {

    private int id;
    private String nameBranch;
    private String address;

    public Branch() {
    }

    public void inputInfoBranch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Request enter nameBranch: ");
        nameBranch = scanner.nextLine();
        System.out.println("Request enter address: ");
        address = scanner.nextLine();
    }

    public Branch(int id, String nameBranch, String address) {
        this.id = id;
        this.nameBranch = nameBranch;
        this.address = address;
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

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", nameBranch='" + nameBranch + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
