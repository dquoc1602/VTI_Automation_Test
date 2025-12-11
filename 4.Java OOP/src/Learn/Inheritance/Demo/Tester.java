package Learn.Inheritance.Demo;

public class Tester extends NhanVien {
    private int soBugTimDuoc; // Thuộc tính riêng của Tester

    public Tester(String maNhanVien, String hoTen, double luongCoBan, int soBugTimDuoc) {
        // Gọi constructor của lớp cha (NhanVien) để gán thông tin chung
        super(maNhanVien, hoTen, luongCoBan);
        this.soBugTimDuoc = soBugTimDuoc;
    }

    // Ghi đè (Override) phương thức tính lương của cha
    // Tester được thưởng 50.000đ cho mỗi con bug tìm ra
    @Override
    public double tinhTongLuong() {
        double thuongBug = soBugTimDuoc * 50000;
        return super.luongCoBan + thuongBug;
    }
}
