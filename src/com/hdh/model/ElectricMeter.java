package com.hdh.model;

public class ElectricMeter {

    private long id;

    private String typeElectricMeter;

    private Contract contract;

    public ElectricMeter(long id, String typeElectricMeter, Contract contract) {
        this.id = id;
        this.typeElectricMeter = typeElectricMeter;
        this.contract = contract;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTypeElectricMeter() {
        return typeElectricMeter;
    }

    public void setTypeElectricMeter(String typeElectricMeter) {
        this.typeElectricMeter = typeElectricMeter;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
