package com.hdh.model;

public class ElectricMeter {

    private long id;

    private String typeElectricMeter;

    private double multiplicationFactor;

    private Contract contract;

    public ElectricMeter(long id, String typeElectricMeter, double multiplicationFactor, Contract contract) {
        this.id = id;
        this.typeElectricMeter = typeElectricMeter;
        this.multiplicationFactor = multiplicationFactor;
        this.contract = contract;
    }

    public ElectricMeter() {
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

    public double getMultiplicationFactor() {
        return multiplicationFactor;
    }

    public void setMultiplicationFactor(double multiplicationFactor) {
        this.multiplicationFactor = multiplicationFactor;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
