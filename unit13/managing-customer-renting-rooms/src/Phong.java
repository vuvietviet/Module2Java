public class Phong implements Comparable<Phong>{
    private String loaiPhong;
    private int giaPhong;
    private String diaChi;

    public Phong() {
    }

    public Phong(String loaiPhong, int giaPhong, String diaChi) {
        this.loaiPhong = loaiPhong;
        this.giaPhong = giaPhong;
        this.diaChi = diaChi;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public int getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(int giaPhong) {
        this.giaPhong = giaPhong;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "loaiPhong='" + loaiPhong + '\'' +
                ", giaPhong=" + giaPhong +
                ", diaChi='" + diaChi;
    }

    @Override
    public int compareTo(Phong o) {
        return this.getGiaPhong() - o.getGiaPhong();
    }
}
