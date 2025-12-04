package Collection.Hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

/**
 * Class HashMapDemo
 * * Mini project chuyên biệt về HashMap.
 * * Demo toàn bộ các thao tác: Put, Get, Remove, ContainsKey, duyệt KeySet/EntrySet.
 */
public class HashMapDemo {

    public static void main(String[] args) {
        System.out.println("================ DEMO HASHMAP ================");

        /**
         * 1. Khởi tạo HashMap
         * - Lưu trữ dưới dạng Key - Value.
         * - Key là duy nhất (Unique). Value có thể trùng.
         * - Không duy trì thứ tự chèn.
         */
        HashMap<String, Integer> productMap = new HashMap<>();
        System.out.println("[Init] Khởi tạo productMap (Key: Tên SP, Value: Giá).");

        /**
         * 2. Thêm phần tử (put)
         * Object put(Key, Value): Thêm cặp key-value. Nếu key đã tồn tại, value sẽ bị ghi đè.
         */
        productMap.put("Laptop Dell", 15000000);
        productMap.put("Macbook Air", 25000000);
        productMap.put("Mouse Logitech", 500000);
        productMap.put("Laptop Dell", 14500000); // Ghi đè giá mới cho key "Laptop Dell"

        System.out.println("[Put] Map hiện tại: " + productMap);

        /**
         * 3. Truy xuất giá trị (get)
         * Object get(Object key): Trả về value tương ứng với key.
         */
        System.out.println("[Get] Giá của 'Macbook Air': " + productMap.get("Macbook Air"));
        System.out.println("[Get] Lấy key không tồn tại (Iphone): " + productMap.get("Iphone")); // Trả về null

        /**
         * 4. Kiểm tra tồn tại (containsKey, containsValue)
         */
        boolean hasMouse = productMap.containsKey("Mouse Logitech");
        System.out.println("[ContainsKey] Có bán chuột không? " + hasMouse);

        /**
         * 5. Xóa phần tử (remove)
         * Object remove(Object key): Xóa entry có key chỉ định.
         */
        productMap.remove("Mouse Logitech");
        System.out.println("[Remove] Map sau khi xóa chuột: " + productMap);

        /**
         * 6. Duyệt Map
         * Cách 1: Duyệt qua KeySet (Tập hợp các Key)
         */
        System.out.println("--- Duyệt qua keySet() ---");
        Set<String> keys = productMap.keySet();
        for (String key : keys) {
            System.out.println("Key: " + key + " | Value: " + productMap.get(key));
        }

        /**
         * Cách 2: Duyệt qua EntrySet (Tập hợp các cặp Key-Value) - Hiệu quả hơn
         */
        System.out.println("--- Duyệt qua entrySet() ---");
        for (Map.Entry<String, Integer> entry : productMap.entrySet()) {
            System.out.println("Sản phẩm: " + entry.getKey() + " - Giá: " + entry.getValue());
        }

        /**
         * 7. Các method tiện ích khác (size, values, clear)
         */
        System.out.println("[Size] Tổng số sản phẩm: " + productMap.size());

        Collection<Integer> prices = productMap.values();
        System.out.println("[Values] Danh sách các mức giá: " + prices);

        productMap.clear();
        System.out.println("[Clear] Map đã xóa rỗng. IsEmpty? " + productMap.isEmpty());
    }
}
