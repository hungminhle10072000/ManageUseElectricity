package com.hdh.model;

public class HouseHold extends Customer {
    public HouseHold(String name, String address, String phoneNumber) {
        super(name, address, phoneNumber);
    }

    public HouseHold(int id, String name, String address, String phoneNumber) {
        super(id, name, address, phoneNumber);
    }

    @Override
    public String toString() {
        return "HouseHold{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", address='" + super.getAddress() + '\'' +
                ", phoneNumber='" + super.getPhoneNumber() + '\'' +
                '}';
    }
}
