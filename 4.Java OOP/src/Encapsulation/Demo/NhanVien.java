package Encapsulation.Demo;

public class NhanVien {
    // --- 1. DỮ LIỆU PRIVATE (Đóng gói) ---
    private String maNV;
    private String tenNV;
    private double luong; // Dữ liệu nhạy cảm, tuyệt đối không để public

    // Constructor: Khởi tạo nhân viên
    public NhanVien(String maNV, String tenNV, double luongBanDau) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        // Kiểm tra ngay từ lúc tạo: Lương không được âm
        if (luongBanDau > 0) {
            this.luong = luongBanDau;
        } else {
            this.luong = 0; // Mặc định là 0 nếu nhập sai
            System.out.println("Lỗi: Lương ban đầu không hợp lệ. Đã set về 0.");
        }
    }

    // --- 2. CÁC PHƯƠNG THỨC PUBLIC (Giao diện truy cập) ---

    // Getter: Chỉ cho xem mã NV, KHÔNG có Setter (nghĩa là Mã NV không thể bị đổi sau khi tạo)
    public String getMaNV() {
        return maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    // Setter cho Tên: Cho phép đổi tên (ví dụ nhân viên đổi họ)
    public void setTenNV(String tenMoi) {
        this.tenNV = tenMoi;
    }

    // Getter cho Lương: Chỉ cho xem
    public double xemLuong() {
        return this.luong;
    }

    // --- NGHIỆP VỤ QUAN TRỌNG ---
    // Không có hàm setLuong() đơn thuần, mà dùng hàm tangLuong() có điều kiện
    public void tangLuong(double phanTramTang) {
        // Validation (Kiểm tra tính hợp lệ)
        if (phanTramTang > 0 && phanTramTang <= 50) {
            // Giả sử quy định công ty: Không được tăng quá 50% một lần
            double luongMoi = this.luong * (1 + phanTramTang / 100);
            this.luong = luongMoi;
            System.out.println("Thành công: Đã tăng lương cho " + this.tenNV);
        } else {
            System.out.println("Thất bại: Phần trăm tăng không hợp lệ (Phải từ 1% - 50%)");
        }
    }
}
