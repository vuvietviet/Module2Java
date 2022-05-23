import java.util.Date;

public class Nguoi {
    private String hoTen;
    private Date ngaySinh;
    private double soCMND;

    public Nguoi() {
    }

    public Nguoi(String hoTen, Date ngaySinh, double soCMND) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCMND = soCMND;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public double getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(double soCMND) {
        this.soCMND = soCMND;
    }

    @Override
    public String toString() {
        return "Nguoi{" +
                "hoTen='" + hoTen + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", soCMND=" + soCMND +
                '}';
    }
}
