package com.hdh.model;

import java.util.Date;
import java.util.List;

public class NoteBook {
    private double index;

    private ElectricMeter electricMeter;
    private Date dateWrite;

    public NoteBook(double index, ElectricMeter electricMeter, Date dateWrite) {
        this.index = index;
        this.electricMeter = electricMeter;
        this.dateWrite = dateWrite;
    }

    public ElectricMeter getElectricMeter() {
        return electricMeter;
    }

    public void setElectricMeter(ElectricMeter electricMeter) {
        this.electricMeter = electricMeter;
    }

    public NoteBook() {
    }

    public Date getDateWrite() {
        return dateWrite;
    }

    public void setDateWrite(Date dateWrite) {
        this.dateWrite = dateWrite;
    }


    public double getIndex() {
        return index;
    }

    public void setIndex(double index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                "index=" + index +
                ", idElectricMeter=" + electricMeter.getId() +
                ", dateWrite=" + dateWrite +
                '}';
    }
}
