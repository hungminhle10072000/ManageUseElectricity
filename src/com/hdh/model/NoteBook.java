package com.hdh.model;

import java.util.Date;

public class NoteBook {

    private long id;

    private Date dateWite;

    private double indexNew;

    private double indexOld;

    private ElectricMeter electricMeter;

    public NoteBook(long id, Date dateWite, double indexNew, double indexOld, ElectricMeter electricMeter) {
        this.id = id;
        this.dateWite = dateWite;
        this.indexNew = indexNew;
        this.indexOld = indexOld;
        this.electricMeter = electricMeter;
    }

    public NoteBook() {
    }

    public long getId() {
        return id;
    }

    public Date getDateWite() {
        return dateWite;
    }

    public double getIndexNew() {
        return indexNew;
    }

    public double getIndexOld() {
        return indexOld;
    }

    public ElectricMeter getElectricMeter() {
        return electricMeter;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDateWite(Date dateWite) {
        this.dateWite = dateWite;
    }

    public void setIndexNew(double indexNew) {
        this.indexNew = indexNew;
    }

    public void setIndexOld(double indexOld) {
        this.indexOld = indexOld;
    }

    public void setElectricMeter(ElectricMeter electricMeter) {
        this.electricMeter = electricMeter;
    }
}
