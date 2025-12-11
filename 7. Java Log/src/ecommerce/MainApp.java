package ecommerce;

public class MainApp {
    public static void main(String[] args) {

        OrderService orderService = new OrderService();

        System.out.println("--- Kịch bản 1: Mua bình thường ---");
        // Log sẽ hiện đầy đủ các bước
        orderService.placeOrder("NguyenVanA", "iPhone 15", 2, 1000);

        System.out.println("\n--- Kịch bản 2: Mua số lượng lớn (Gây cảnh báo kho - WARN) ---");
        // Sẽ thấy log WARN từ InventoryService vì kho còn ít
        orderService.placeOrder("TranVanB", "iPhone 15", 5, 1000);

        System.out.println("\n--- Kịch bản 3: Mua quá số tiền (Gây lỗi thanh toán - ERROR) ---");
        // Sẽ thấy log ERROR từ PaymentService
        orderService.placeOrder("RichKid", "iPhone 15", 1, 15000);

        System.out.println("\n--- Kịch bản 4: Mua quá kho (Gây lỗi kho - ERROR) ---");
        // Sẽ thấy log ERROR từ InventoryService
        orderService.placeOrder("SlowGuy", "iPhone 15", 100, 1000);
    }
}