package Learn.StaticKeyword.Demo;

/**
 * Class Main: StaticDemo
 * Chạy chương trình để kiểm chứng tính năng của từ khóa Static.
 */
public class StaticDemo {

    public static void main(String[] args) {
        System.out.println("========= DEMO TỪ KHÓA STATIC =========");

        /**
         * 1. KIỂM TRA STATIC BLOCK & STATIC VARIABLE
         * Ngay khi truy cập CompanyPolicy, khối static sẽ chạy trước tiên.
         */
        System.out.println("CEO hiện tại: " + CompanyPolicy.CEO_NAME);

        System.out.println("\n--------- TUYỂN DỤNG NHÂN SỰ ---------");

        /**
         * 2. KIỂM TRA CHIA SẺ BỘ NHỚ CỦA STATIC VARIABLE
         */
        // Ban đầu chưa có nhân viên nào
        System.out.println("Số nhân viên ban đầu: " + Employee.numberOfEmployees);

        // Tạo nhân viên 1
        Employee emp1 = new Employee("Nguyen Van A", 2000);
        // Tạo nhân viên 2
        Employee emp2 = new Employee("Tran Thi B", 800);

        // In thông tin
        emp1.showInfo();
        System.out.println("---");
        emp2.showInfo();

        System.out.println("\n--------- KIỂM TRA TỔNG KẾT ---------");
        // Mặc dù gọi từ emp1 hay emp2, giá trị numberOfEmployees là NHƯ NHAU.
        System.out.println("emp1 thấy số nhân viên là: " + emp1.numberOfEmployees); // (Cảnh báo: Nên gọi qua Class)
        System.out.println("emp2 thấy số nhân viên là: " + emp2.numberOfEmployees);
        System.out.println("Employee class thấy số nhân viên là: " + Employee.numberOfEmployees);

        /**
         * 3. SỬ DỤNG STATIC METHOD TIỆN ÍCH
         * Không cần tạo đối tượng TaxUtil mới dùng được hàm tính toán.
         */
        System.out.println("\n--------- THỬ NGHIỆM TIỆN ÍCH ---------");
        double testSalary = 5000;
        System.out.println("Thử tính thuế cho mức lương 5000: " + TaxUtil.calculateTax(testSalary));

        System.out.println("=======================================");
    }
}