package FinalKeyword.Demo;

/**
 * Class: AppConfig
 * Dùng để minh họa biến FINAL (Hằng số).
 */
public class AppConfig {

    /**
     * BIẾN FINAL (FINAL VARIABLE):
     * Khi một biến được khai báo là static final, nó trở thành hằng số của cả hệ thống.
     * Quy ước đặt tên: Viết hoa toàn bộ và dùng dấu gạch dưới (_).
     */
    public static final String BANK_NAME = "VTI GLOBAL BANK";

    /**
     * Biến final thông thường (Instance variable):
     * Giá trị phải được gán ngay khi khai báo hoặc trong Constructor.
     * Sau khi gán, không thể thay đổi giá trị này nữa.
     */
    public final String appVersion;

    public AppConfig() {
        // Gán giá trị lần đầu tiên (và duy nhất) cho biến final
        this.appVersion = "v1.0.2";
    }
}
