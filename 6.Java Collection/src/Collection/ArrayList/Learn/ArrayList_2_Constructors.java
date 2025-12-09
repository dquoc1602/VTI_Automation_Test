package Collection.ArrayList.Learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ArrayList_2_Constructors {
    public static void main(String[] args) {

        // --- 1. Hàm tạo: ArrayList() ---

        // Khởi tạo một danh sách mảng trống.
        // Sức chứa (capacity) ban đầu mặc định là 10.
        ArrayList<String> defaultList = new ArrayList<>();

        System.out.println("--- 1. ArrayList() (Mặc định) ---");
        System.out.println("Kích thước hiện tại: " + defaultList.size()); // 0

        defaultList.add("Apple");
        defaultList.add("Banana");
        System.out.println("Danh sách: " + defaultList);
        // Dù size là 2, capacity ẩn là 10.

        // --- 2. Hàm tạo: ArrayList(Collection c) ---

        // Tạo một Collection c ban đầu để truyền vào hàm tạo
        Collection<String> initialData = Arrays.asList("Red", "Green", "Blue");

        // Khởi tạo một danh sách mảng với các phần tử của collection c.
        // Sức chứa ban đầu sẽ đủ để chứa tất cả các phần tử của c.
        ArrayList<String> collectionList = new ArrayList<>(initialData);

        System.out.println("\n--- 2. ArrayList(Collection c) ---");
        System.out.println("Kích thước hiện tại: " + collectionList.size()); // 3
        System.out.println("Danh sách: " + collectionList);

        collectionList.add("Yellow"); // Vẫn có thể thêm phần tử
        System.out.println("Danh sách sau khi thêm: " + collectionList);

        // --- 3. Hàm tạo: ArrayList(int capacity) ---

        // Khởi tạo một danh sách mảng với sức chứa ban đầu chỉ định là 5.
        // Điều này giúp tối ưu hiệu suất nếu biết trước danh sách sẽ có ít hơn 5 phần tử.
        int initialCapacity = 5;
        ArrayList<Integer> capacityList = new ArrayList<>(initialCapacity);

        System.out.println("\n--- 3. ArrayList(int capacity) & Cơ chế Tăng kích thước ---");

        // Thêm 5 phần tử (Vẫn trong giới hạn capacity = 5)
        for (int i = 1; i <= 5; i++) {
            capacityList.add(i * 10);
        }
        System.out.println("Kích thước hiện tại (size): " + capacityList.size()); // 5
        // Sức chứa (capacity) vẫn là 5

        // Thêm phần tử thứ 6 (VƯỢT QUÁ SỨC CHỨA)
        // Khi thêm phần tử thứ 6 (khi capacity = 5):
        // 1. ArrayList tự động tăng kích thước (thường là N * 1.5 + 1).
        // 2. Với Java 8 trở lên, công thức thường là: old_capacity + (old_capacity / 2) (tăng 50%).
        // Kích thước mới = 5 + (5 / 2) = 5 + 2 = 7 (hoặc 5 + 3 = 8 tùy theo cài đặt cụ thể)
        capacityList.add(60);

        System.out.println("Thêm phần tử thứ 6 vào list (capacity ban đầu = 5).");
        System.out.println("Kích thước hiện tại (size): " + capacityList.size()); // 6
        System.out.println("Danh sách: " + capacityList);
        // Lưu ý: Chúng ta không thể truy xuất trực tiếp giá trị capacity,
        // nhưng chúng ta biết nó đã tự động tăng lên để chứa phần tử thứ 6.

        // Thêm tiếp để kiểm tra kích thước mới (size = 7)
        capacityList.add(70); // Vẫn hoạt động

        // Thêm phần tử thứ 8 (capacity mới sẽ lại tăng)
        // Nếu capacity là 7, nó sẽ tăng lên 7 + 7/2 = 10
        capacityList.add(80);
        System.out.println("Sau khi thêm đến phần tử thứ 8 (size): " + capacityList.size()); // 8
    }
}
