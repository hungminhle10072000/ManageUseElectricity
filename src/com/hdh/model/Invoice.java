package com.hdh.model;

import java.util.Date;

public class Invoice {

    private long id;

    private double totalMoney;

    private Date dateFrom;

    private Date dateEnd;

    private boolean status;

    private NoteBook noteBook;

    public Invoice(long id, double totalMoney, Date dateFrom, Date dateEnd, boolean status, NoteBook noteBook) {
        this.id = id;
        this.totalMoney = totalMoney;
        this.dateFrom = dateFrom;
        this.dateEnd = dateEnd;
        this.status = status;
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

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public NoteBook getNoteBook() {
        return noteBook;
    }

    public void setNoteBook(NoteBook noteBook) {
        this.noteBook = noteBook;
    }
}
