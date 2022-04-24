package com.hdh.model;

import java.util.Date;

public class Invoice implements BaseModel {

    private int id;

    private double totalMoney;

    private Date dateFrom;

    private Date dateEnd;

    private boolean status;

    private NoteBook noteBook;


    public Invoice() {
    }

    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
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

    @Override
    public String toString() {
//        2*java.lang.Integer.valueOf(1+java.lang.String.format("%0"+5+"d",0))
        String statusPay = status ? "Đã thanh toán" : "Chưa thanh toán";
        return "Invoice{" +
                "idInvoice=" + id +
                ", totalMoney=" + totalMoney +
                ", dateFrom=" + dateFrom +
                ", dateEnd=" + dateEnd +
                ", customer=" + noteBook.getElectricMeter().getContract().getCustomer().getName() +
                ", electric=" + noteBook.getElectricMeter().getId() +
                ", status=" + statusPay +
                '}';
    }
}
