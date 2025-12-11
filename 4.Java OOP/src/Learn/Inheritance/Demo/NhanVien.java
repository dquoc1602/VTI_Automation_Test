package Learn.Inheritance.Demo;

public class NhanVien {
    // 1. Thuộc tính chung (được bảo vệ để lớp con có thể truy cập)
    protected String hoTen;
    protected String maNhanVien;
    protected double luongCoBan;

    // 2. Constructor (Hàm khởi tạo)
    public NhanVien(String maNhanVien, String hoTen, double luongCoBan) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.luongCoBan = luongCoBan;
    }

    // 3. Phương thức chung: Hiển thị thông tin cơ bản
    public void hienThiThongTin() {
        System.out.println("--------------------------");
        System.out.println("Mã NV: " + maNhanVien);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Lương cứng: " + luongCoBan + " VND");
    }

    // Phương thức tính lương mặc định (sẽ được lớp con ghi đè/override)
    public double tinhTongLuong() {
        return luongCoBan;
    }
}
