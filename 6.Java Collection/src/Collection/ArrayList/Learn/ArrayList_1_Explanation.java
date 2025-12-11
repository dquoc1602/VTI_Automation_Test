package Collection.ArrayList.Learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayList_1_Explanation {

    public static void main(String[] args) {

        // 1. Kích thước linh hoạt & Khả năng lưu trữ nhiều kiểu (Raw Type - KHÔNG KHUYẾN KHÍCH)
        // Lưu ý: Thường nên sử dụng Generics (ArrayList<String>, ArrayList<Integer>)
        ArrayList rawList = new ArrayList();

        System.out.println("--- 1. Kích thước Linh hoạt & Không cần khai báo kiểu trước ---");
        rawList.add("Apple");  // Kiểu String
        rawList.add(123);      // Kiểu Integer (Autoboxing)
        rawList.add(true);     // Kiểu Boolean (Autoboxing)

        System.out.println("Kích thước sau khi thêm 3 phần tử: " + rawList.size());

        // 2. Chứa phần tử trùng lặp & Duy trì thứ tự
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Banana"); // index 0
        fruits.add("Apple");  // index 1
        fruits.add("Banana"); // index 2 (Phần tử trùng lặp)

        System.out.println("\n--- 2. Chứa phần tử trùng lặp & Duy trì thứ tự ---");
        System.out.println("Danh sách (duy trì thứ tự): " + fruits);

        // 3. Truy cập phần tử ngẫu nhiên (get) - Tốc độ nhanh (O(1))
        System.out.println("\n--- 3. Truy cập Ngẫu nhiên (get) - Tốc độ O(1) ---");
        // Truy cập phần tử tại index 1
        System.out.println("Phần tử tại index 1: " + fruits.get(1));

        // 4. Thao tác thêm/xóa (add/remove) - Minh họa hiệu suất (chậm)
        // Chúng ta sẽ dùng ArrayList<Integer> để dễ dàng thao tác
        ArrayList<Integer> numbers = new ArrayList<>();
        int MAX_ELEMENTS = 100000;

        for (int i = 0; i < MAX_ELEMENTS; i++) {
            numbers.add(i);
        }

        // Đo thời gian thao tác thêm/xóa ở VỊ TRÍ ĐẦU (index 0)
        // Đây là kịch bản chậm nhất vì cần dịch chuyển tất cả các phần tử
        long startTime = System.nanoTime();

        // Thêm một phần tử vào VỊ TRÍ ĐẦU tiên (index 0)
        numbers.add(0, 999999);

        // Xóa phần tử tại VỊ TRÍ ĐẦU tiên (index 0)
        numbers.remove(0);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // Đổi sang mili giây

        System.out.println("\n--- 4. Hiệu suất Thêm/Xóa (add/remove) - Chậm (O(n)) ---");
        System.out.println("Thời gian thêm/xóa 1 phần tử ở index 0 trong list " +
                "có " + MAX_ELEMENTS + " phần tử: " + duration + " ms");
        System.out.println("(Do cần dịch chuyển khoảng " + MAX_ELEMENTS + " phần tử)");

        // Thêm/Xóa ở VỊ TRÍ CUỐI (Tốc độ nhanh O(1))
        startTime = System.nanoTime();
        numbers.add(MAX_ELEMENTS - 1, 999999); // Thêm ở cuối
        numbers.remove(MAX_ELEMENTS - 1); // Xóa ở cuối
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000;
        System.out.println("Thời gian thêm/xóa 1 phần tử ở index cuối: " + duration + " ms (Nhanh hơn đáng kể)");

        // 5. Tính chất Không Đồng Bộ (Non-synchronized)
        // Trong môi trường đa luồng (multi-threaded), ArrayList không an toàn.
        // Cần sử dụng Collections.synchronizedList hoặc Vector nếu cần đồng bộ.
        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        System.out.println("\n--- 5. Không Đồng Bộ (Non-synchronized) ---");
        System.out.println("ArrayList mặc định không an toàn cho đa luồng. " +
                "Cần dùng Collections.synchronizedList hoặc Vector.");
    }
}