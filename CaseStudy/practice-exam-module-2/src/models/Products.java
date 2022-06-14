package models;

public class Products{
    private String id;
    private String name;
    private double price;
    private int amount;
    private String detail;

    public Products() {
    }

    public Products(String id, String name, double price, int amount, String detail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.detail = detail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", detail='" + detail + '\'' +
                '}';
    }

    public String write() {
        return id + "," + name + "," + price + "," + amount + "," + detail;
    }
}
