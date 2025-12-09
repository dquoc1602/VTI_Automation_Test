package StaticKeyword.Demo;

/**
 * Class: CompanyPolicy (Chính sách công ty)
 * Dùng để minh họa KHỐI STATIC (STATIC BLOCK) và BIẾN STATIC.
 */
public class CompanyPolicy {

    /**
     * BIẾN STATIC (Class Variable):
     * Biến này thuộc về lớp CompanyPolicy, không thuộc về một đối tượng cụ thể nào.
     * Chỉ có DUY NHẤT một bản sao của biến này trong bộ nhớ.
     */
    public static String CEO_NAME;
    public static double BASE_SALARY;

    /**
     * KHỐI STATIC (STATIC BLOCK):
     * Khối lệnh này chỉ chạy ĐÚNG MỘT LẦN khi lớp CompanyPolicy được nạp vào bộ nhớ (Class Loading).
     * Thường dùng để khởi tạo giá trị cho các biến static phức tạp hoặc lấy cấu hình từ file/database.
     */
    static {
        System.out.println("--- [System] Đang nạp cấu hình công ty... ---");
        CEO_NAME = "Mr. Pham Nhat Vuong";
        BASE_SALARY = 5000.0; // Lương cơ bản chung
        System.out.println("--- [System] Cấu hình hoàn tất. ---");
    }
}