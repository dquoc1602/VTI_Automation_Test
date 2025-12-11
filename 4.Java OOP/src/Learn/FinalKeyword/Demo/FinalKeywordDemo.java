package Learn.FinalKeyword.Demo;

/**
 * Lớp chính: FinalKeywordDemo
 * Chạy chương trình để kiểm tra các tính chất của từ khóa final.
 */
public class FinalKeywordDemo {

    public static void main(String[] args) {
        System.out.println("========= DEMO TỪ KHÓA FINAL =========");

        /**
         * 1. DEMO BIẾN FINAL
         */
        System.out.println("1. Tên ngân hàng (Hằng số): " + AppConfig.BANK_NAME);

        AppConfig config = new AppConfig();
        System.out.println("   Phiên bản App: " + config.appVersion);

        // config.appVersion = "v2.0"; // LỖI: Không thể gán lại giá trị cho biến final.

        System.out.println("\n--------------------------------------");

        /**
         * 2. DEMO LỚP FINAL (SecurityKernel)
         */
        System.out.println("2. Sử dụng lớp SecurityKernel (Final Class)");
        SecurityKernel security = new SecurityKernel();
        security.encryptData("Mật khẩu tài khoản 123");
        // Không thể tạo class con kế thừa SecurityKernel để thay đổi cách mã hóa.

        System.out.println("\n--------------------------------------");

        /**
         * 3. DEMO PHƯƠNG THỨC FINAL
         */
        System.out.println("3. Thực hiện giao dịch Online");
        OnlineTransaction onlineTx = new OnlineTransaction();

        // Gọi phương thức final từ lớp cha (không bị sửa đổi)
        onlineTx.verifySignature();

        // Gọi phương thức đã được override
        onlineTx.processPayment();

        System.out.println("======================================");
    }
}