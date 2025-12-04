package Inheritance.Demo;

public class QuanLyNhanSu {
    public static void main(String[] args) {
        // Tạo đối tượng Tester
        Tester banQuoc = new Tester("NV01", "Lê Đức Quốc", 10000000, 20); // Tìm được 20 bugs

        // Tạo đối tượng Developer
        Developer banNam = new Developer("NV02", "Nguyễn Văn Nam", 12000000, 5); // OT 5 tiếng

        // --- IN KẾT QUẢ ---

        // 1. Hiển thị thông tin (Dùng hàm của lớp cha NhanVien)
        banQuoc.hienThiThongTin();
        // 2. Tính lương (Dùng hàm đã được Tester định nghĩa lại)
        System.out.println("=> TỔNG LƯƠNG THỰC NHẬN: " + banQuoc.tinhTongLuong() + " VND");

        banNam.hienThiThongTin();
        System.out.println("=> TỔNG LƯƠNG THỰC NHẬN: " + banNam.tinhTongLuong() + " VND");
    }
}
