package com.hdh.model;

import java.util.Date;
import java.util.List;

public class NoteBook {

    private Date dateWrite;

    private int idElectricMeter;

    private double index;

    private List<ElectricMeter> electricMeters;

    public NoteBook(Date dateWrite, int idElectricMeter, double index) {
        this.dateWrite = dateWrite;
        this.idElectricMeter = idElectricMeter;
        this.index = index;
    }
    public NoteBook() {
    }

    public Date getDateWrite() {
        return dateWrite;
    }

    public void setDateWrite(Date dateWrite) {
        this.dateWrite = dateWrite;
    }

    public int getIdElectricMeter() {
        return idElectricMeter;
    }

    public void setIdElectricMeter(int idElectricMeter) {
        this.idElectricMeter = idElectricMeter;
    }

    public double getIndex() {
        return index;
    }

    public void setIndex(double index) {
        this.index = index;
    }

    public List<ElectricMeter> getElectricMeters() {
        return electricMeters;
    }

    public void setElectricMeters(List<ElectricMeter> electricMeters) {
        this.electricMeters = electricMeters;
    }
}
