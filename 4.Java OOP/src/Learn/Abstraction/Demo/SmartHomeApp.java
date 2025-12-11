package Learn.Abstraction.Demo;

/**
 * Lớp chính: SmartHomeApp
 * Mô phỏng ứng dụng điều khiển nhà thông minh.
 */
public class SmartHomeApp {

    public static void main(String[] args) {
        /**
         * 1. KHỞI TẠO ĐỐI TƯỢNG
         * Chúng ta không thể viết: SmartDevice device = new SmartDevice("Test"); // Lỗi biên dịch!
         * Vì SmartDevice là trừu tượng (không hoàn chỉnh).
         */

        // Tạo robot hút bụi
        SmartDevice robot = new RoboVacuum("Xiaomi Robot", 85);

        // Tạo camera an ninh
        SmartDevice camera = new SecurityCamera("Camera Cổng Trước", true);

        System.out.println("====== KHỞI ĐỘNG HỆ THỐNG NHÀ THÔNG MINH ======");

        /**
         * 2. SỬ DỤNG TÍNH TRỪU TƯỢNG
         * Người dùng (lớp main) chỉ cần biết các đối tượng này là SmartDevice.
         * Người dùng gọi connectToWifi() và operate() mà không cần quan tâm
         * bên trong nó xử lý phức tạp như thế nào (ẩn chi tiết).
         */

        // Điều khiển Robot
        robot.connectToWifi();
        robot.operate(); // Gọi hàm abstract, nhưng chạy code của RoboVacuum

        System.out.println(); // Dòng trống

        // Điều khiển Camera
        camera.connectToWifi();
        camera.operate(); // Gọi hàm abstract, nhưng chạy code của SecurityCamera

        System.out.println("===============================================");
    }
}
