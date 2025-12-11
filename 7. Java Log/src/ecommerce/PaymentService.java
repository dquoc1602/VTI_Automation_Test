package ecommerce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentService {
    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    public boolean processPayment(String user, double amount) {
        logger.info("Bắt đầu xử lý thanh toán cho: " + user + " | Số tiền: " + amount);

        // Giả lập lỗi ngẫu nhiên (Ví dụ: Mất kết nối cổng thanh toán)
        if (amount > 10000) {
            // Giả sử thanh toán trên 10,000$ cần xác thực đặc biệt và bị lỗi
            logger.error("LỖI THANH TOÁN: Timeout kết nối đến ngân hàng cho giao dịch lớn.");
            return false;
        }


        logger.info("Thanh toán thành công!");
        return true;
    }
}