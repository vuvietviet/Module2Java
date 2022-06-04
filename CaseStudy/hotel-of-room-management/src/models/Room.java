package models;

public class Room {
    private String nameRoom;
    private int priceRoom;
    private String statusRoom;
    private int toiletNumber;
    private int bedroomNumber;

    public Room() {
    }

    public Room(String nameRoom, int priceRoom, String statusRoom,
                int toiletNumber, int bedroomNumber) {
        this.nameRoom = nameRoom;
        this.priceRoom = priceRoom;
        this.statusRoom = statusRoom;
        this.toiletNumber = toiletNumber;
        this.bedroomNumber = bedroomNumber;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public int getPriceRoom() {
        return priceRoom;
    }

    public void setPriceRoom(int priceRoom) {
        this.priceRoom = priceRoom;
    }

    public String getStatusRoom() {
        return statusRoom;
    }

    public void setStatusRoom(String statusRoom) {
        this.statusRoom = statusRoom;
    }

    public int getToiletNumber() {
        return toiletNumber;
    }

    public void setToiletNumber(int toiletNumber) {
        this.toiletNumber = toiletNumber;
    }

    public int getBedroomNumber() {
        return bedroomNumber;
    }

    public void setBedroomNumber(int bedroomNumber) {
        this.bedroomNumber = bedroomNumber;
    }

    @Override
    public String toString() {
        return "Room{" +
                "nameRoom='" + nameRoom + '\'' +
                ", priceRoom=" + priceRoom +
                ", statusRoom='" + statusRoom + '\'' +
                ", toiletNumber=" + toiletNumber +
                ", bedroomNumber=" + bedroomNumber +
                '}';
    }

    public String write() {
        return nameRoom + "," + priceRoom + "," + statusRoom + "," +
                toiletNumber + "," + bedroomNumber;
    }
}
