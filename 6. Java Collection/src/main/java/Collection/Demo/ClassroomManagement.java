package Collection.Demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Class ClassroomManagement
 * * Mini Project kết hợp cả ArrayList và HashMap.
 * * Ứng dụng: Quản lý danh sách sinh viên theo từng lớp học.
 * * Cấu trúc dữ liệu: HashMap<String, ArrayList<String>>
 * - Key (String): Tên lớp học (Ví dụ: "Java01", "FrontEnd02").
 * - Value (ArrayList<String>): Danh sách tên các sinh viên trong lớp đó.
 */
public class ClassroomManagement {

    /** * database: Lưu trữ dữ liệu toàn bộ chương trình.
     * Key là tên lớp, Value là danh sách sinh viên.
     */
    private static HashMap<String, ArrayList<String>> classroomMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= HỆ THỐNG QUẢN LÝ LỚP HỌC =========");
            System.out.println("1. Thêm lớp học mới (Add Class)");
            System.out.println("2. Thêm sinh viên vào lớp (Add Student to Class)");
            System.out.println("3. Hiển thị danh sách sinh viên của một lớp (Get Students)");
            System.out.println("4. Hiển thị tất cả các lớp và sinh viên (Show All)");
            System.out.println("5. Xóa sinh viên khỏi lớp (Remove Student)");
            System.out.println("6. Xóa lớp học (Remove Class)");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addClass();
                    break;
                case "2":
                    addStudentToClass();
                    break;
                case "3":
                    showStudentsInClass();
                    break;
                case "4":
                    showAllClasses();
                    break;
                case "5":
                    removeStudent();
                    break;
                case "6":
                    removeClass();
                    break;
                case "0":
                    System.out.println("Đã thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    /**
     * Chức năng 1: Thêm một lớp học mới.
     * Sử dụng HashMap.put() để thêm key mới, và khởi tạo ArrayList rỗng cho value.
     */
    private static void addClass() {
        System.out.print("Nhập tên lớp học mới (VD: Java01): ");
        String className = scanner.nextLine();

        /** Kiểm tra xem lớp đã tồn tại trong HashMap chưa */
        if (classroomMap.containsKey(className)) {
            System.out.println("Lỗi: Lớp " + className + " đã tồn tại!");
        } else {
            /** * Thêm lớp vào Map.
             * Value là một ArrayList rỗng vì mới tạo lớp chưa có ai.
             */
            classroomMap.put(className, new ArrayList<>());
            System.out.println("Đã thêm lớp: " + className);
        }
    }

    /**
     * Chức năng 2: Thêm sinh viên vào một lớp cụ thể.
     * Kết hợp HashMap.get() để lấy ArrayList, sau đó dùng ArrayList.add().
     */
    private static void addStudentToClass() {
        System.out.print("Nhập tên lớp muốn thêm sinh viên: ");
        String className = scanner.nextLine();

        if (classroomMap.containsKey(className)) {
            System.out.print("Nhập tên sinh viên: ");
            String studentName = scanner.nextLine();

            /** * B1: Lấy danh sách sinh viên (ArrayList) từ HashMap dựa trên tên lớp
             */
            ArrayList<String> students = classroomMap.get(className);

            /** * B2: Thêm sinh viên vào danh sách đó
             */
            students.add(studentName);
            System.out.println("Đã thêm sinh viên '" + studentName + "' vào lớp " + className);
        } else {
            System.out.println("Lỗi: Không tìm thấy lớp " + className);
        }
    }

    /**
     * Chức năng 3: Hiển thị danh sách sinh viên của 1 lớp.
     * Dùng HashMap.get() để lấy ArrayList và duyệt.
     */
    private static void showStudentsInClass() {
        System.out.print("Nhập tên lớp cần xem: ");
        String className = scanner.nextLine();

        if (classroomMap.containsKey(className)) {
            ArrayList<String> students = classroomMap.get(className);

            if (students.isEmpty()) {
                System.out.println("Lớp " + className + " hiện chưa có sinh viên nào.");
            } else {
                System.out.println("--- Danh sách lớp " + className + " ---");
                /** Duyệt qua ArrayList sinh viên */
                for (int i = 0; i < students.size(); i++) {
                    System.out.println((i + 1) + ". " + students.get(i));
                }
            }
        } else {
            System.out.println("Lỗi: Lớp không tồn tại.");
        }
    }

    /**
     * Chức năng 4: Hiển thị toàn bộ dữ liệu.
     * Duyệt qua HashMap (KeySet) và với mỗi Key, duyệt qua ArrayList (Value).
     */
    private static void showAllClasses() {
        if (classroomMap.isEmpty()) {
            System.out.println("Hệ thống chưa có dữ liệu lớp học nào.");
            return;
        }

        System.out.println("\n=== DANH SÁCH TỔNG HỢP ===");
        /** Duyệt qua tập hợp các Key (Tên lớp) */
        for (String className : classroomMap.keySet()) {
            ArrayList<String> students = classroomMap.get(className);
            System.out.println("Lớp: " + className + " | Số lượng: " + students.size());
            System.out.println("   -> Sinh viên: " + students);
        }
    }

    /**
     * Chức năng 5: Xóa sinh viên khỏi lớp.
     * Dùng HashMap để tìm lớp, dùng ArrayList.remove() để xóa sinh viên.
     */
    private static void removeStudent() {
        System.out.print("Nhập tên lớp: ");
        String className = scanner.nextLine();

        if (classroomMap.containsKey(className)) {
            ArrayList<String> students = classroomMap.get(className);

            System.out.print("Nhập tên sinh viên cần xóa: ");
            String studentName = scanner.nextLine();

            /** Kiểm tra sinh viên có trong list không */
            if (students.contains(studentName)) {
                students.remove(studentName);
                System.out.println("Đã xóa sinh viên " + studentName + " khỏi lớp " + className);
            } else {
                System.out.println("Không tìm thấy sinh viên này trong lớp.");
            }
        } else {
            System.out.println("Lớp không tồn tại.");
        }
    }

    /**
     * Chức năng 6: Xóa hoàn toàn một lớp học.
     * Dùng HashMap.remove().
     */
    private static void removeClass() {
        System.out.print("Nhập tên lớp muốn giải thể: ");
        String className = scanner.nextLine();

        if (classroomMap.containsKey(className)) {
            classroomMap.remove(className);
            System.out.println("Đã xóa hoàn toàn lớp: " + className);
        } else {
            System.out.println("Lớp không tồn tại.");
        }
    }
}