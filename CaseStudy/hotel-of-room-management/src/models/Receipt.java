package models;

import java.util.Date;

public class Receipt extends Room{
    private String idReceipt;
    private Date startTime;
    private Date endTime;
    private String rentalStaffName;
    private String customerName;

    public Receipt() {
    }

    public Receipt(String idReceipt,Date startTime, Date endTime, String rentalStaffName, String customerName) {
        this.idReceipt = idReceipt;
        this.startTime = startTime;
        this.endTime = endTime;
        this.rentalStaffName = rentalStaffName;
        this.customerName = customerName;
    }

    public Receipt(String nameRoom, int priceRoom, String idReceipt,Date startTime, Date endTime,
                   String rentalStaffName, String customerName) {
        super(nameRoom, priceRoom);
        this.idReceipt = idReceipt;
        this.startTime = startTime;
        this.endTime = endTime;
        this.rentalStaffName = rentalStaffName;
        this.customerName = customerName;
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

    public int calculateTotalDate() {
        return endTime.getDate() - startTime.getDate();
    }

    public int calculateTotalAReceipt() {
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
                "totalPayable=" + calculateTotalAReceipt() +
                '}';
    }

    public String write() {
        return super.getNameRoom() + "," + super.getPriceRoom() + "," +
                idReceipt + "," + startTime + "," + endTime + "," +
                rentalStaffName + "," + customerName;
    }
}
