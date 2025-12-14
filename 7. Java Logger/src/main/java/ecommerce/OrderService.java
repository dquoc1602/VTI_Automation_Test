package ecommerce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderService {
    // Mỗi class có một Logger riêng để biết log đến từ đâu [cite: 339]
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private InventoryService inventoryService = new InventoryService();
    private PaymentService paymentService = new PaymentService();

    public void placeOrder(String user, String product, int quantity, double pricePerUnit) {
        // Log INFO: Đánh dấu bắt đầu một quy trình lớn (Business Flow)
        logger.info(">>> NHẬN ĐƠN HÀNG MỚI: User=" + user + ", Product=" + product);

        // 1. Tính toán giá tiền (Sử dụng DEBUG)
        // Tại sao dùng DEBUG? Vì công thức tính tiền có thể phức tạp, ta chỉ cần xem khi fix bug.
        // Khi chạy thật (Production), ta tắt DEBUG đi để log không bị đầy.
        double total = quantity * pricePerUnit;
        logger.debug("Tính toán giá: " + quantity + " * " + pricePerUnit + " = " + total);

        if (total > 5000) {
            double discount = total * 0.1; // Giảm 10%
            total -= discount;
            logger.debug("Áp dụng giảm giá VIP 10%: -" + discount + ". Tổng mới: " + total);
        }

        // 2. Gọi sang kho hàng
        boolean hasStock = inventoryService.checkAndReduceStock(product, quantity);
        if (!hasStock) {
            logger.info("Hủy đơn hàng do hết kho.");
            return; // Dừng
        }

        // 3. Gọi thanh toán
        boolean paid = paymentService.processPayment(user, total);
        if (!paid) {
            logger.error("Hủy đơn hàng do thanh toán thất bại.");
            // Ở thực tế, có thể thêm logic hoàn lại kho (rollback) tại đây
            return;
        }

        logger.info("<<< ĐƠN HÀNG HOÀN TẤT THÀNH CÔNG CHO " + user);
    }
}
