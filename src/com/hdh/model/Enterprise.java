package com.hdh.model;

public class Enterprise extends Customer {

    public Enterprise(String name, String address, String phoneNumber) {
        super(name, address, phoneNumber);
    }

    public Enterprise(int id, String name, String address, String phoneNumber) {
        super(id, name, address, phoneNumber);
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", address='" + super.getAddress() + '\'' +
                ", phoneNumber='" + super.getPhoneNumber() + '\'' +
                '}';
    }
}
