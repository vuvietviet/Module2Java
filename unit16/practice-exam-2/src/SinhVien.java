import java.util.Date;

public class SinhVien {
    private String hoTen;
    private String MSV;
    private Date ngaySinh;
    private String lop;

    public SinhVien() {
    }

    public SinhVien(String hoTen, String MSV, Date ngaySinh, String lop) {
        this.hoTen = hoTen;
        this.MSV = MSV;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMSV() {
        return MSV;
    }

    public void setMSV(String MSV) {
        this.MSV = MSV;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    @Override
    public String toString() {
        return " || hoTen='" + hoTen + '\'' +
                ", MSV='" + MSV + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", lop='" + lop;
    }
}
