package Learn.StaticKeyword.Demo;

/**
 * Class: Employee (Nhân viên)
 * Dùng để minh họa sự khác biệt giữa Static Variable và Instance Variable.
 */
public class Employee {

    /**
     * BIẾN STATIC: numberOfEmployees
     * Đây là "Bộ đếm chung". Mọi đối tượng Employee đều nhìn thấy và chia sẻ biến này.
     * Dùng để đếm tổng số nhân viên đã được tuyển dụng.
     */
    public static int numberOfEmployees = 0;

    /**
     * BIẾN INSTANCE (Non-static):
     * Mỗi đối tượng Employee sẽ có một bản sao riêng của biến này (tên riêng, lương riêng).
     */
    private String name;
    private double salary;
    private int employeeId;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;

        // Tăng biến static lên 1 mỗi khi có nhân viên mới được tạo (new)
        numberOfEmployees++;

        // Gán ID cho nhân viên dựa trên số lượng hiện tại
        this.employeeId = numberOfEmployees;
    }

    public void showInfo() {
        // Gọi phương thức static bên trong phương thức thường là hoàn toàn hợp lệ
        double tax = TaxUtil.calculateTax(this.salary);

        System.out.println("ID: " + this.employeeId + " | Tên: " + this.name);
        System.out.println("   -> Lương: " + this.salary + "$");
        System.out.println("   -> Thuế TNCN: " + tax + "$");

        // Truy cập biến static (có thể dùng tên lớp Employee.numberOfEmployees hoặc trực tiếp)
        System.out.println("   -> (Hiện tại công ty đang có: " + Employee.numberOfEmployees + " nhân sự)");
    }
}