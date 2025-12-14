package space;

/**
 * Mô phỏng hệ thống lõi để minh họa log FATAL.
 */
public class SystemCore {
    private SimLogger logger = new SimLogger(SystemCore.class);

    public void bootSystem() {
        logger.info("Hệ thống đang khởi động các module...");

        // Giả lập kiểm tra phần cứng
        boolean diskFailure = true;

        if (diskFailure) {
            // [ERROR] Lỗi chí mạng.
            // Khi gặp lỗi này, thường ứng dụng sẽ không thể chạy tiếp.
            // Admin hệ thống phải nhận được tin nhắn cảnh báo ngay lập tức (SMS/Email).
            logger.error("Ổ CỨNG BỊ HỎNG! KHÔNG THỂ GHI DỮ LIỆU. HỆ THỐNG DỪNG KHẨN CẤP.");
        }
    }
}