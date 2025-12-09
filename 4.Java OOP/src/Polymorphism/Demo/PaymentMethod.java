package Polymorphism.Demo;

/**
 * Lớp cha: PaymentMethod
 * Đại diện cho một phương thức thanh toán trừu tượng/chung chung.
 */
public class PaymentMethod {

    /**
     * Phương thức thanh toán cơ bản.
     * Trong Đa hình, phương thức này sẽ bị "Ghi đè" (Override) bởi các lớp con.
     * * @param amount Số tiền cần thanh toán.
     */
    public void pay(double amount) {
        System.out.println("Thanh toán phương thức mặc định: " + amount);
    }
}
