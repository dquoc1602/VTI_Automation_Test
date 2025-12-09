package Polymorphism.Demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Lớp chính để chạy chương trình.
 */
public class PaymentSystem {

    public static void main(String[] args) {
        /**
         * 1. KHỞI TẠO DỮ LIỆU
         * Tạo ra một danh sách các hóa đơn cần thanh toán.
         * * ĐIỂM QUAN TRỌNG CỦA ĐA HÌNH:
         * Chúng ta khai báo List chứa kiểu dữ liệu là lớp cha (PaymentMethod),
         * nhưng thực tế lại chứa các đối tượng của lớp con (CreditCard, EWallet, Cash).
         * Đây gọi là Upcasting (Ép kiểu lên).
         */
        List<PaymentMethod> transactionList = new ArrayList<>();

        // Khách hàng A dùng thẻ tín dụng
        transactionList.add(new CreditCard("1234567890128888", "NGUYEN VAN A"));

        // Khách hàng B dùng ví Momo
        transactionList.add(new EWallet("0909123456", "Momo"));

        // Khách hàng C trả tiền mặt
        transactionList.add(new Cash());

        /**
         * 2. XỬ LÝ THANH TOÁN (Runtime Polymorphism)
         * Duyệt qua danh sách và gọi hàm pay().
         * * Tại thời điểm biên dịch (Compile time), Java chỉ biết 'payment' là PaymentMethod.
         * Nhưng tại thời điểm chạy (Runtime), Java sẽ tự động xác định đối tượng thực sự
         * là CreditCard, EWallet hay Cash để gọi hàm pay() tương ứng.
         */
        double orderValue = 500000.0; // Giá trị đơn hàng giả định

        System.out.println("=== BẮT ĐẦU XỬ LÝ CÁC GIAO DỊCH ===");

        for (PaymentMethod payment : transactionList) {
            // Lời gọi hàm giống nhau, nhưng hành vi thực hiện khác nhau
            payment.pay(orderValue);
        }
    }
}
