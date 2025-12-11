package Learn.Encapsulation.Demo;

public class QuanLyNhanSu {
    public static void main(String[] args) {
        // 1. Tạo một nhân viên mới
        System.out.println("--- KHỞI TẠO NHÂN VIÊN ---");
        NhanVien nv1 = new NhanVien("NV001", "Nguyen Van A", 10000000);
        System.out.println("Nhân viên: " + nv1.getTenNV() + " - Lương: " + nv1.xemLuong());

        // 2. Tình huống cố tình phá hoại (Vi phạm quy tắc Đóng Gói)
        System.out.println("\n--- THỬ TRUY CẬP TRÁI PHÉP ---");

        // Dòng dưới đây sẽ BÁO LỖI NGAY LẬP TỨC (Compile Error) nếu bỏ comment
        // nv1.luong = -5000000;
        // nv1.luong = 999999999;
        System.out.println("Không thể truy cập trực tiếp vào biến 'luong' vì nó là private!");

        // 3. Tăng lương sai quy định (Validation hoạt động)
        System.out.println("\n--- THỬ TĂNG LƯƠNG SAI QUY ĐỊNH ---");
        nv1.tangLuong(100); // Cố tình tăng 100%
        System.out.println("Lương hiện tại: " + nv1.xemLuong());

        // 4. Tăng lương đúng quy định
        System.out.println("\n--- TĂNG LƯƠNG HỢP LỆ ---");
        nv1.tangLuong(20); // Tăng 20%
        System.out.println("Lương sau khi tăng: " + nv1.xemLuong());

        // 5. Thử đổi Mã Nhân Viên
        // nv1.maNV = "NV002"; // Lỗi: private
        // nv1.setMaNV("NV002"); // Lỗi: Không tồn tại hàm này
        System.out.println("\n--- BẢO VỆ DỮ LIỆU ---");
        System.out.println("Mã nhân viên được bảo vệ (Read-only), không thể thay đổi.");

        /**Giả định thực tế về đi ăn bún đậu mắm tôm.*/
    }
}
