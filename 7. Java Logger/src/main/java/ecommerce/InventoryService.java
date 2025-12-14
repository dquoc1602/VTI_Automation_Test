package ecommerce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InventoryService {
    private static final Logger logger = LoggerFactory.getLogger(InventoryService.class);
    private int stockQuantity = 10; // Giả sử kho còn 10 cái iPhone

    public boolean checkAndReduceStock(String product, int quantity) {


        logger.debug("Đang kiểm tra kho cho sản phẩm: " + product + " với số lượng: " + quantity);

        if (quantity > stockQuantity) {
            // Log ERROR: Lỗi nghiệp vụ nghiêm trọng (bán quá số lượng có)
            logger.error("Hết hàng! Khách mua " + quantity + " nhưng kho chỉ còn " + stockQuantity);
            return false;
        }

        stockQuantity -= quantity;
        logger.info("Đã trừ kho thành công. Tồn kho hiện tại: " + stockQuantity);

        // Log WARN: Cảnh báo nhưng hệ thống vẫn chạy tiếp.
        // Logic: Nếu tồn kho < 5 thì cảnh báo nhập hàng.
        if (stockQuantity < 5) {
            logger.warn("CẢNH BÁO: Hàng sắp hết (" + stockQuantity + " sản phẩm). Cần nhập thêm ngay!");
        }

        return true;
    }
}
