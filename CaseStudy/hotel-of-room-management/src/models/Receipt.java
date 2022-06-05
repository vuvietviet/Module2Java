package models;

import java.util.Date;

public class Receipt extends Room{
    private Date startTime;
    private Date endTime;
    private String rentalStaffName;
    private String customerName;

    public Receipt() {
    }

    public Receipt(Date startTime, Date endTime, String rentalStaffName, String customerName) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.rentalStaffName = rentalStaffName;
        this.customerName = customerName;
    }

    public Receipt(String nameRoom, int priceRoom, Date startTime, Date endTime,
                   String rentalStaffName, String customerName) {
        super(nameRoom, priceRoom);
        this.startTime = startTime;
        this.endTime = endTime;
        this.rentalStaffName = rentalStaffName;
        this.customerName = customerName;
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

    public int calculateTotalAmount() {
        return endTime.getDate() - startTime.getDate();
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "nameRoom='" + super.getNameRoom() + '\'' +
                ", priceRoom=" + super.getPriceRoom() +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", rentalStaffName='" + rentalStaffName + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }

    public String write() {
        return super.getNameRoom() + "," + super.getPriceRoom() + "," + startTime + "," + endTime + "," + rentalStaffName + "," + customerName;
    }
}
