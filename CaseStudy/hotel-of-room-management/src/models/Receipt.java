package models;

import calculateDate.CalculateDate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipt extends Room{
    private String idReceipt;
    private Date startTime;
    private Date endTime;
    private String rentalStaffName;
    private String customerName;
    private String statusReceipt;
    CalculateDate calculateDate = new CalculateDate();

    public Receipt() {
    }

    public Receipt(String idReceipt,Date startTime, Date endTime, String rentalStaffName, String customerName, String statusReceipt) {
        this.idReceipt = idReceipt;
        this.startTime = startTime;
        this.endTime = endTime;
        this.rentalStaffName = rentalStaffName;
        this.customerName = customerName;
        this.statusReceipt = statusReceipt;
    }

    public Receipt(String nameRoom, int priceRoom, String idReceipt,Date startTime, Date endTime,
                   String rentalStaffName, String customerName, String statusReceipt) {
        super(nameRoom, priceRoom);
        this.idReceipt = idReceipt;
        this.startTime = startTime;
        this.endTime = endTime;
        this.rentalStaffName = rentalStaffName;
        this.customerName = customerName;
        this.statusReceipt = statusReceipt;
    }

    public String getIdReceipt() {
        return idReceipt;
    }

    public void setIdReceipt(String idReceipt) {
        this.idReceipt = idReceipt;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRentalStaffName() {
        return rentalStaffName;
    }

    public void setRentalStaffName(String rentalStaffName) {
        this.rentalStaffName = rentalStaffName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatusReceipt() {
        return statusReceipt;
    }

    public void setStatusReceipt(String statusReceipt) {
        this.statusReceipt = statusReceipt;
    }

    public int calculateTotalDate() {
        return calculateDate.calculateTotalDate(startTime,endTime);
    }

    public int calculateTotalPayable() {
        return calculateTotalDate() * super.getPriceRoom();
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "nameRoom='" + super.getNameRoom() + '\'' +
                ", priceRoom=" + super.getPriceRoom() +
                ", idReceipt=" + idReceipt +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", rentalStaffName='" + rentalStaffName + '\'' +
                ", customerName='" + customerName + '\'' +
                ", statusReceipt='" +statusReceipt + '\'' +
                "totalPayable=" + calculateTotalPayable() +
                '}';
    }

    public String write() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return super.getNameRoom() + "," + super.getPriceRoom() + "," +
                idReceipt + "," + formatter.format(startTime) + "," + formatter.format(endTime) + "," +
                rentalStaffName + "," + customerName + "," + statusReceipt;
    }
}
