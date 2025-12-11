package Learn.FinalKeyword.Demo;

/**
 * Class: Transaction (Giao dịch)
 * Dùng để minh họa phương thức FINAL.
 */
public class Transaction {

    /**
     * PHƯƠNG THỨC FINAL (FINAL METHOD): verifySignature
     * * Ý nghĩa:
     * Phương thức này quy định quy trình xác thực chữ ký điện tử chuẩn.
     * Tác giả của lớp này KHÔNG muốn các lớp con (subclass) thay đổi logic xác thực này
     * (để tránh gian lận hoặc bỏ qua bước bảo mật).
     * Do đó, phương thức này không thể bị Ghi đè (Override).
     */
    public final void verifySignature() {
        System.out.println("--- B1. Kiểm tra chữ ký điện tử: BẮT BUỘC (Logic gốc không thể sửa đổi) ---");
        System.out.println("--- B2. Xác thực thành công.");
    }

    /**
     * Phương thức thông thường:
     * Các lớp con có thể thoải mái ghi đè (Override) phương thức này.
     */
    public void processPayment() {
        System.out.println("Xử lý thanh toán mặc định.");
    }
}