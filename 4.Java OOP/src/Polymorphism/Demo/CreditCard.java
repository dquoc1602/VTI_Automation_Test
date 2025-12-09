package Polymorphism.Demo;

/**
 * Lớp con 1: CreditCard (Thẻ tín dụng)
 * Kế thừa từ PaymentMethod.
 */
public class CreditCard extends PaymentMethod {
    private String cardNumber;
    private String cardHolder;

    public CreditCard(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    /**
     * @Override (Ghi đè phương thức)
     * Đây là biểu hiện của Đa hình tại Runtime.
     * Cùng là hành động 'pay', nhưng thẻ tín dụng sẽ xử lý xác thực thẻ và tính phí.
     */
    @Override
    public void pay(double amount) {
        // Giả lập tính phí dịch vụ 2% cho thẻ tín dụng
        double fee = amount * 0.02;
        double total = amount + fee;

        System.out.println("-------------------------------------------------");
        System.out.println("Đang thanh toán qua THẺ TÍN DỤNG...");
        System.out.println("Chủ thẻ: " + cardHolder + " | Số thẻ: " + maskCardNumber(cardNumber));
        System.out.println("Gốc: " + amount + " + Phí (2%): " + fee);
        System.out.println("=> TỔNG TRỪ TÀI KHOẢN: " + total + " VND");
        System.out.println("-------------------------------------------------");
    }

    // Hàm phụ trợ để ẩn số thẻ
    private String maskCardNumber(String number) {
        return "xxxx-xxxx-xxxx-" + number.substring(number.length() - 4);
    }
}