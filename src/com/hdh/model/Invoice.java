package com.hdh.model;

import java.text.DecimalFormat;
import java.util.Date;

public class Invoice implements BaseModel {

    private int id;

    private double totalMoney;

    private Date dateFrom;

    private Date dateEnd;

    private boolean status;

    private NoteBook noteBook;

    private double totalIndex;

    public double getTotalIndex() {
        return totalIndex;
    }

    public void setTotalIndex(double totalIndex) {
        this.totalIndex = totalIndex;
    }

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

//    @Override
//    public String toString() {
//        String statusPay = status ? "Paid" : "Unpaid";
//        String pattern = "###,###,### VNĐ";
//        DecimalFormat decimalFormat = new DecimalFormat(pattern);
//        return "Invoice{" +
//                "idInvoice=" + id +
//                ", totalMoney=" + decimalFormat.format(totalMoney) +
//                ", dateFrom=" + dateFrom +
//                ", dateEnd=" + dateEnd +
//                ", customer=" + noteBook.getElectricMeter().getContract().getCustomer().getName() +
//                ", electric=" + noteBook.getElectricMeter().getId() +
//                ", status=" + statusPay +
//                '}';
//    }

    @Override
    public String toString() {
        String statusPay = status ? "Paid" : "Unpaid";
        String pattern = "###,###,### VNĐ";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return "Invoice{" +
                "totalMoney=" + decimalFormat.format(totalMoney) +
                ", dateFrom=" + dateFrom +
                ", dateEnd=" + dateEnd +
                ", status=" + statusPay +
                ", customer=" + noteBook.getElectricMeter().getContract().getCustomer().getName() +
                ", electric=" + noteBook.getElectricMeter().getId() +
                ", totalIndex=" + totalIndex + " Kwh" +
        '}';
    }
}
