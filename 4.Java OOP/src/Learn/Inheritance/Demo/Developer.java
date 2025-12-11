package Learn.Inheritance.Demo;

public class Developer extends NhanVien {
    private int gioOT; // Thuộc tính riêng của Dev

    public Developer(String maNhanVien, String hoTen, double luongCoBan, int gioOT) {
        super(maNhanVien, hoTen, luongCoBan);
        this.gioOT = gioOT;
    }

    // Dev được trả 200.000đ cho mỗi giờ OT
    @Override
    public double tinhTongLuong() {
        double tienOT = gioOT * 200000;
        return super.luongCoBan + tienOT;
    }
}