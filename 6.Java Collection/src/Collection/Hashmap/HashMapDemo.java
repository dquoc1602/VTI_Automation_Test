package Collection.Hashmap;

import java.util.HashMap;
import java.util.Map;

// Lớp Đối Tượng Tùy Chỉnh (Value)
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class HashMapDemo {

    public static void main(String[] args) {

        // HashMap chính: Key là String (Mã sản phẩm), Value là đối tượng Product
        // Ví dụ này minh họa việc sử dụng Object làm Value.
        HashMap<String, Product> productMap = new HashMap<>();

        System.out.println("--- 1. HashMap với Key (String) và Value (Object Tùy Chỉnh) ---");

        // Thêm các cặp key-value
        productMap.put("P001", new Product("Laptop", 1200.0));
        productMap.put("P002", new Product("Mouse", 25.5));
        productMap.put("P003", new Product("Keyboard", 75.0));

        // Lấy dữ liệu
        Product laptop = productMap.get("P001");
        System.out.println("Sản phẩm P001: " + laptop);

        // --- 2. HashMap với Key (Integer) và Value (String) ---

        // Ví dụ này minh họa việc sử dụng Key không phải là String.
        // Key là Integer (Mã vùng), Value là String (Tên vùng)
        HashMap<Integer, String> areaCodes = new HashMap<>();

        System.out.println("\n--- 2. HashMap với Key (Integer) ---");

        areaCodes.put(101, "Ha Noi");
        areaCodes.put(202, "TP. Ho Chi Minh");
        areaCodes.put(303, "Da Nang");

        System.out.println("Mã 202 thuộc: " + areaCodes.get(202));

        // --- 3. Minh họa Key/Value là NULL và Key duy nhất ---

        // HashMap có thể chứa Key là null và Value là null
        HashMap<String, String> configMap = new HashMap<>();

        System.out.println("\n--- 3. Minh họa Key/Value là NULL và Key duy nhất ---");

        // Cho phép 1 Key là null
        configMap.put(null, "Giá trị mặc định của hệ thống");

        // Cho phép nhiều Value là null
        configMap.put("ServerName", "ServerA");
        configMap.put("Timeout", null); // Giá trị null

        // Key duy nhất: Ghi đè Key null nếu gọi put() lần nữa
        String previousValue = configMap.put(null, "Giá trị null mới");
        System.out.println("Giá trị cũ của Key null: " + previousValue); // Output: Giá trị mặc định...

        System.out.println("Giá trị của key null hiện tại: " + configMap.get(null));
        System.out.println("Giá trị của key Timeout: " + configMap.get("Timeout"));

        // --- 4. Lặp qua các cặp Key/Value (Để thấy KHÔNG có thứ tự) ---

        System.out.println("\n--- 4. Duyệt qua HashMap (Thứ tự KHÔNG đảm bảo) ---");
        // Ta sử dụng entrySet() để duyệt qua cả Key và Value
        for (Map.Entry<String, String> entry : configMap.entrySet()) {
            // Lưu ý: Key null sẽ được in là 'null'
            System.out.println("Key: " + entry.getKey() + " => Value: " + entry.getValue());
        }
    }
}