package Polymorphism.Demo;

/**
 * Lớp con 2: EWallet (Ví điện tử - Momo/ZaloPay)
 * Kế thừa từ PaymentMethod.
 */
public class EWallet extends PaymentMethod {
    private String phoneNumber;
    private String appName;

    public EWallet(String phoneNumber, String appName) {
        this.phoneNumber = phoneNumber;
        this.appName = appName;
    }

    /**
     * @Override
     * Ví điện tử xử lý khác với thẻ tín dụng (ví dụ: hoàn tiền/cashback).
     */
    @Override
    public void pay(double amount) {
        System.out.println("-------------------------------------------------");
        System.out.println("Đang thanh toán qua VÍ ĐIỆN TỬ (" + appName + ")...");
        System.out.println("Số điện thoại: " + phoneNumber);
        System.out.println("=> ĐÃ THANH TOÁN: " + amount + " VND");
        System.out.println("(Bạn nhận được thẻ quà tặng cho lần sau)");
        System.out.println("-------------------------------------------------");
    }
}
