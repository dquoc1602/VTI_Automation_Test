package Learn.Polymorphism.Demo;

/**
 * Lớp con 3: Cash (Tiền mặt)
 * Kế thừa từ PaymentMethod.
 */
public class Cash extends PaymentMethod {

    /**
     * @Override
     * Tiền mặt chỉ đơn giản là nhận tiền, không cần xác thực phức tạp.
     */
    @Override
    public void pay(double amount) {
        System.out.println("-------------------------------------------------");
        System.out.println("Thanh toán bằng TIỀN MẶT tại quầy.");
        System.out.println("=> Đã nhận đủ: " + amount + " VND");
        System.out.println("-------------------------------------------------");
    }
}