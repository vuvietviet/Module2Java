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

    public Receipt(String nameRoom, int priceRoom, String statusRoom, int toiletNumber,
                   int bedroomNumber, Date startTime, Date endTime, String rentalStaffName, String customerName) {
        super(nameRoom, priceRoom, statusRoom, toiletNumber, bedroomNumber);
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

    @Override
    public String toString() {
        return "Receipt{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", rentalStaffName='" + rentalStaffName + '\'' +
                ", customerName='" + customerName + '\'' +
                '}';
    }

    public String write() {
        return startTime + "," + endTime + "," + rentalStaffName + "," + customerName;
    }
}
