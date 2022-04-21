package com.hdh.model;

public class ElectricMeter implements BaseModel{

    private int id;

    private String typeElectricMeter;

    private Contract contract;

    public ElectricMeter(String typeElectricMeter, Contract contract) {
        this.typeElectricMeter = typeElectricMeter;
        this.contract = contract;
    }

    public ElectricMeter(int id, String typeElectricMeter, Contract contract) {
        this.id = id;
        this.typeElectricMeter = typeElectricMeter;
        this.contract = contract;
    }

    @Override
    public String toString() {
        return "ElectricMeter{" +
                "id=" + id +
                ", typeElectricMeter='" + typeElectricMeter + '\'' +
                ", contract=" + contract.toString() +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
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
