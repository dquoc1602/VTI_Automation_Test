package Collection.ArrayList;

import java.util.ArrayList;

/**
 * Class ArrayListDemo
 * * Mini project chuyên biệt về ArrayList.
 * * Demo toàn bộ các thao tác: Khởi tạo, Add, Get, Set, Remove, RetainAll, RemoveAll, toArray.
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        System.out.println("================ DEMO ARRAYLIST ================");

        /**
         * 1. Khởi tạo ArrayList
         * - Không cần khai báo trước số lượng phần tử.
         * - Duy trì thứ tự thêm vào.
         * - Có thể chứa phần tử trùng lặp.
         */
        ArrayList<String> studentList = new ArrayList<>();
        System.out.println("[Init] Khởi tạo studentList trống.");

        /**
         * 2. Thêm phần tử (add)
         * boolean add(Object o): Thêm vào cuối danh sách.
         * void add(int index, Object element): Chèn vào vị trí chỉ định.
         */
        studentList.add("Nguyen Van A");
        studentList.add("Tran Thi B");
        studentList.add("Le Van C");
        studentList.add(1, "Hoang Van D (Chen vao index 1)"); // Chèn vào giữa
        System.out.println("[Add] Danh sách sau khi thêm: " + studentList);

        /**
         * 3. Truy xuất và Tìm kiếm (get, indexOf)
         * Object get(int index): Trả về phần tử tại index.
         * int indexOf(Object o): Tìm vị trí xuất hiện đầu tiên.
         */
        String studentAt2 = studentList.get(2);
        System.out.println("[Get] Sinh viên tại index 2: " + studentAt2);
        System.out.println("[IndexOf] Vị trí của 'Le Van C': " + studentList.indexOf("Le Van C"));

        /**
         * 4. Cập nhật phần tử (set)
         * Object set(int index, Object element): Thay thế phần tử tại vị trí đã cho.
         */
        studentList.set(0, "Nguyen Van A (Updated)");
        System.out.println("[Set] Danh sách sau khi update index 0: " + studentList);

        /**
         * 5. Xóa phần tử (remove)
         * Object remove(int index): Gỡ bỏ phần tử tại index.
         */
        studentList.remove(1); // Xóa phần tử tại index 1
        System.out.println("[Remove] Danh sách sau khi xóa index 1: " + studentList);

        /**
         * 6. Tạo một danh sách khác để demo addAll, removeAll, retainAll
         */
        ArrayList<String> otherList = new ArrayList<>();
        otherList.add("Le Van C");
        otherList.add("Pham Van E");

        /**
         * addAll(Collection c): Thêm tất cả phần tử của otherList vào studentList
         */
        studentList.addAll(otherList);
        System.out.println("[AddAll] Sau khi thêm otherList vào: " + studentList);

        /**
         * retainAll(Collection c): Chỉ giữ lại các phần tử CÓ trong collection c (Giao của 2 tập hợp).
         * Ở đây chỉ giữ lại những ai có tên trong otherList ("Le Van C", "Pham Van E").
         */
        // Tạo bản sao để test retainAll vì nó sẽ thay đổi list gốc
        ArrayList<String> copyList = new ArrayList<>(studentList);
        copyList.retainAll(otherList);
        System.out.println("[RetainAll] Chỉ giữ lại phần tử chung với otherList: " + copyList);

        /**
         * removeAll(Collection c): Loại bỏ tất cả phần tử có trong collection c khỏi list này.
         */
        studentList.removeAll(otherList);
        System.out.println("[RemoveAll] Xóa tất cả phần tử thuộc otherList: " + studentList);

        /**
         * 7. Chuyển đổi sang Mảng (toArray)
         */
        Object[] arr = studentList.toArray();
        System.out.println("[ToArray] Số phần tử trong mảng thường: " + arr.length);

        /**
         * 8. Dọn dẹp (clear) và Kiểm tra (isEmpty, size)
         */
        studentList.clear();
        System.out.println("[Clear] Đã xóa toàn bộ. Size hiện tại: " + studentList.size());
    }
}
