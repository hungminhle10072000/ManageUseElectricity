package com.hdh.model;

import java.util.Date;

public class Invoice {

    private long id;

    private boolean status;

    private Date date;

    private double totalMoney;

    private NoteBook noteBook;

    public Invoice(long id, boolean status, Date date, double totalMoney, NoteBook noteBook) {
        this.id = id;
        this.status = status;
        this.date = date;
        this.totalMoney = totalMoney;
        this.noteBook = noteBook;
    }

    public Invoice() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public NoteBook getNoteBook() {
        return noteBook;
    }

    public void setNoteBook(NoteBook noteBook) {
        this.noteBook = noteBook;
    }
}
