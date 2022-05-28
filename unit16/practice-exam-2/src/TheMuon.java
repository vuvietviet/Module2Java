import java.util.Date;


public class TheMuon extends SinhVien{
    private int soPhieuMuon;
    private Date ngayMuon;
    private Date hanTra;
    private String soHieuSach;

    public TheMuon() {
    }

    public TheMuon(int soPhieuMuon, Date ngayMuon, Date hanTra, String soHieuSach) {
        this.soPhieuMuon = soPhieuMuon;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
        this.soHieuSach = soHieuSach;
    }

    public TheMuon(String hoTen, String MSV, Date ngaySinh, String lop,
                   int soPhieuMuon, Date ngayMuon, Date hanTra, String soHieuSach) {
        super(hoTen, MSV, ngaySinh, lop);
        this.soPhieuMuon = soPhieuMuon;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
        this.soHieuSach = soHieuSach;
    }

    public int getSoPhieuMuon() {
        return soPhieuMuon;
    }

    public void setSoPhieuMuon(int soPhieuMuon) {
        this.soPhieuMuon = soPhieuMuon;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getHanTra() {
        return hanTra;
    }

    public void setHanTra(Date hanTra) {
        this.hanTra = hanTra;
    }

    public String getSoHieuSach() {
        return soHieuSach;
    }

    public void setSoHieuSach(String soHieuSach) {
        this.soHieuSach = soHieuSach;
    }

    @Override
    public String toString() {
        return "soPhieuMuon=" + soPhieuMuon +
                ", ngayMuon=" + ngayMuon +
                ", hanTra=" + hanTra +
                ", soHieuSach='" + soHieuSach + super.toString();
    }
}
