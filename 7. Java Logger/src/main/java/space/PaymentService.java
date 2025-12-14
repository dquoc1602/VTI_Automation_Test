package space;

public class PaymentService {
    private SimLogger logger = new SimLogger(PaymentService.class);

    public void processPayment(String user, int amount) {

        // === INFO (luồng nghiệp vụ chính) ===
        logger.info("Nhận yêu cầu thanh toán từ user: " + user);

        // === DEBUG (chi tiết dành cho Developer) ===
        logger.debug("Bắt đầu kiểm tra dữ liệu đầu vào...");
        logger.debug("User = " + user + ", Amount = " + amount);

        logger.debug("Đang kiểm tra số dư ví trong DB...");
        logger.debug("SQL Query: SELECT balance FROM wallet WHERE user = '" + user + "';");

        double serviceFee = amount * 0.02;
        logger.debug("Tính phí dịch vụ: " + serviceFee);

        logger.debug("Kiểm tra hạn mức giao dịch hằng ngày của user...");
        logger.debug("DailyLimitUsed = 350000 / DailyLimitMax = 2000000");

        // === WARN (những vấn đề nhẹ nhưng hệ thống vẫn chạy) ===
        if (amount > 1000000) {
            logger.warn("Giao dịch giá trị lớn: " + amount + " -> Cần lưu lại để Audit!");
        }

        if (amount == 0) {
            logger.warn("Giao dịch với số tiền = 0 -> Hành vi bất thường, ghi lại để kiểm tra.");
        }

        if (user.toLowerCase().contains("test")) {
            logger.warn("Phát hiện user test thực hiện giao dịch ở môi trường Production.");
        }

        if (serviceFee > 20000) {
            logger.warn("Phí dịch vụ cao bất thường (" + serviceFee + "), kiểm tra cấu hình phí.");
        }

        logger.warn("Độ trễ kết nối Bank API tăng cao (380ms). Tiếp tục xử lý...");

        // === TRACE (siêu chi tiết, từng bước nhỏ, thường để debug lỗi khó tìm) ===
        logger.trace("Khởi tạo PaymentContext...");
        logger.trace("PaymentContext.user = " + user);
        logger.trace("PaymentContext.amount = " + amount);
        logger.trace("Thiết lập mã giao dịch (UUID)...");
        logger.trace("Mở kết nối Socket đến Bank API...");
        logger.trace("Gửi gói tin HANDSHAKE...");
        logger.trace("Chờ ACK từ Bank...");
        logger.trace("ACK nhận thành công.");
        logger.trace("Gửi gói tin AUTH_USER...");
        logger.trace("Bank xác thực thành công, tiếp tục...");

        logger.trace("Bắt đầu quy trình mã hóa transaction payload...");
        logger.trace("payload = AES256.encrypt(json)...");
        logger.trace("Gửi payload tới Bank...");
        logger.trace("Chờ phản hồi RESULT_CODE...");

        try {
            // Tạo lỗi giả lập
            if (amount < 0) {
                logger.debug("Phát hiện số tiền âm, chuẩn bị ném Exception...");
                throw new IllegalArgumentException("Số tiền âm không hợp lệ");
            }

            // Mọi thứ ok
            logger.trace("Bank RESULT_CODE = 00 (SUCCESS)");
            logger.info("Thanh toán THÀNH CÔNG cho user " + user + " số tiền " + amount + "đ.");

        } catch (Exception e) {

            // === ERROR (lỗi thật) ===
            logger.error("Thanh toán THẤT BẠI do lỗi: " + e.getMessage());
            logger.debug("StackTrace (rút gọn): " + e.getClass().getSimpleName());
            logger.trace("StackTrace đầy đủ: " + e);

            logger.warn("Giao dịch thất bại -> thêm vào retry queue trong 5 phút.");
        }
    }
}
