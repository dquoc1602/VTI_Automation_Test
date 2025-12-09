package Collection.ArrayList.Learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ArrayList_3_Capacity {
    // Phương thức giả lập để ước lượng capacity (Trong Java, không có phương thức public để lấy capacity)
    // Chúng ta sẽ quan sát hành vi của list để suy luận
    private static void printCapacityObservation(ArrayList<?> list, int currentCapacity, String action) {
        System.out.println("-> Hành động: " + action);
        System.out.println("   Kích thước hiện tại (size): " + list.size());
        System.out.println("   Capacity ước tính trước hành động: " + currentCapacity);
    }

    public static void main(String[] args) {

        // --- 1. ArrayList(int capacity) - Sức chứa ban đầu 5 ---

        int initialCapacity = 5;
        // Khởi tạo một danh sách với sức chứa ban đầu chỉ định là 5
        ArrayList<String> growingList = new ArrayList<>(initialCapacity);
        int currentCapacity = initialCapacity; // Biến theo dõi capacity ước tính

        System.out.println("--- 1. ArrayList(int capacity = 5) và Cơ chế Tăng trưởng ---");

        // Thêm 5 phần tử (Vẫn trong giới hạn capacity = 5)
        for (int i = 1; i <= 5; i++) {
            growingList.add("Element " + i);
            // capacity không thay đổi
        }
        printCapacityObservation(growingList, currentCapacity, "Thêm 5 phần tử đầu tiên");

        // --- Thao tác Cần Tăng Kích Thước ---

        // Thêm phần tử thứ 6 (VƯỢT QUÁ CAPACITY = 5)
        // Khi list đầy (size=5), Java sẽ phải tăng kích thước.
        // Công thức tăng trưởng (thường là 50%): 5 + (5 / 2) = 7 (hoặc 8 tùy JVM)

        // Giả định Capacity mới là 7 (5 + 2)
        growingList.add("Element 6");
        currentCapacity = 7;

        printCapacityObservation(growingList, currentCapacity, "Thêm phần tử thứ 6 (Tăng capacity)");

        // Thêm phần tử thứ 7 (Vẫn trong giới hạn capacity = 7)
        boolean has = growingList.add("Element 7");
        System.out.println(has);
        printCapacityObservation(growingList, currentCapacity, "Thêm phần tử thứ 7");

        // Thêm phần tử thứ 8 (VƯỢT QUÁ CAPACITY = 7)
        // Khi list đầy (size=7), Java sẽ tăng kích thước lần nữa.
        // Công thức tăng trưởng: 7 + (7 / 2) = 7 + 3 = 10
        growingList.add("Element 8");
        currentCapacity = 10;

        printCapacityObservation(growingList, currentCapacity, "Thêm phần tử thứ 8 (Tăng capacity lần 2)");

        System.out.println("Danh sách cuối cùng: " + growingList);

        // --- 2. ArrayList() - Sức chứa Mặc định 10 ---

        ArrayList<Integer> defaultList = new ArrayList<>();
        int defaultCapacity = 10;

        System.out.println("\n--- 2. ArrayList() - Sức chứa Mặc định 10 ---");
        System.out.println("Kích thước khởi tạo: " + defaultList.size()); // 0
        // Mặc dù size là 0, capacity đã là 10.

        // Thêm 10 phần tử
        for (int i = 1; i <= 10; i++) {
            defaultList.add(i);
        }
        printCapacityObservation(defaultList, defaultCapacity, "Thêm 10 phần tử (Vẫn trong capacity)");

        // Thêm phần tử thứ 11 (VƯỢT QUÁ CAPACITY = 10)
        // Công thức tăng trưởng: 10 + (10 / 2) = 15
        defaultList.add(11);
        defaultCapacity = 15;

        printCapacityObservation(defaultList, defaultCapacity, "Thêm phần tử thứ 11 (Tăng capacity lên 15)");
    }
}
