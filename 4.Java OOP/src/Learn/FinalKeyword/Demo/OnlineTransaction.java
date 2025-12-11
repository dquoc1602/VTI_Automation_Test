package Learn.FinalKeyword.Demo;

/**
 * Class: OnlineTransaction
 * Kế thừa từ Transaction để minh họa việc cố gắng ghi đè phương thức final.
 */
public class OnlineTransaction extends Transaction {

    /**
     * @Override
     * Phương thức này KHÔNG có từ khóa final ở lớp cha, nên ta có thể ghi đè thoải mái.
     */
    @Override
    public void processPayment() {
        System.out.println(">> Xử lý thanh toán ONLINE qua Internet Banking.");
    }

    /*
     * LỖI BIÊN DỊCH (COMPILE ERROR):
     * Nếu bạn bỏ chú thích (uncomment) đoạn code dưới đây, chương trình sẽ báo lỗi.
     * Lý do: verifySignature() ở lớp cha là 'final', không thể bị ghi đè.
     */
    /*
    @Override
    public void verifySignature() {
        System.out.println("Cố tình bỏ qua bước xác thực để hack!");
    }
    */
}