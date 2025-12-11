package Learn.StaticKeyword.Demo;

/**
 * Class: TaxUtil (Tiện ích thuế)
 * Dùng để minh họa PHƯƠNG THỨC STATIC (STATIC METHOD).
 */
public class TaxUtil {

    /**
     * PHƯƠNG THỨC STATIC (Class Method):
     * 1. Có thể gọi trực tiếp thông qua tên lớp: TaxUtil.calculateTax(...)
     * 2. Không cần từ khóa 'new' để tạo đối tượng TaxUtil.
     * 3. Phương thức này hoạt động độc lập, không phụ thuộc vào dữ liệu của đối tượng nào.
     */
    public static double calculateTax(double salary) {
        if (salary < 1000) {
            return 0;
        } else {
            return salary * 0.1; // Thuế 10%
        }
    }

    /**
     * Lưu ý: Trong phương thức static, không thể sử dụng từ khóa 'this' hoặc 'super'.
     */
}
