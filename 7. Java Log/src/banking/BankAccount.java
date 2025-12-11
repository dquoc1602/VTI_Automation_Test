package banking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class mô phỏng tài khoản ngân hàng.
 * Sử dụng SLF4J để ghi log thay vì System.out.println để khắc phục nhược điểm không lưu được ra file[cite: 99, 143].
 */
public class BankAccount {

    /**
     * Khởi tạo đối tượng Logger thông qua LoggerFactory của SLF4J.
     * Đây là cách phổ biến nhất để quản lý log trong doanh nghiệp[cite: 142, 339].
     */
    private static final Logger logger = LoggerFactory.getLogger(BankAccount.class);

    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;

        logger.info("\n\n-------------------- NEW RUN SESSION --------------------");
        // Ghi log INFO: Thông báo một tài khoản mới được khởi tạo thành công
        logger.info("Tạo mới tài khoản cho khách hàng: " + accountHolder + " | Số dư ban đầu: " + initialBalance);
    }

    /**
     * Phương thức gửi tiền (Deposit)
     * @param amount Số tiền cần gửi
     */
    public void deposit(double amount) {


        // Debugging concept: Đây là vị trí lý tưởng để đặt Breakpoint nếu số dư bị sai[cite: 19].

        if (amount <= 0) {
            // Ghi log ERROR: Ghi lại lỗi nghiêm trọng hoặc dữ liệu không hợp lệ
            logger.error("Giao dịch thất bại: Số tiền gửi không hợp lệ (" + amount + ")");
            return;
        }

        this.balance += amount;

        // Ghi log INFO: Ghi lại lịch sử giao dịch thành công để tra cứu sau này 
        logger.info("Gửi tiền THÀNH CÔNG. Số tiền: " + amount + " | Số dư mới: " + this.balance);
    }

    /**
     * Phương thức rút tiền (Withdraw)
     * @param amount Số tiền cần rút
     */
    public void withdraw(double amount) {
        // Kiểm tra logic trước khi thực hiện
        if (amount > this.balance) {
            // Ghi log WARN hoặc INFO: Cảnh báo hành vi rút quá số dư (không phải lỗi hệ thống nhưng là lỗi nghiệp vụ)
            logger.warn("Cảnh báo: Khách hàng " + accountHolder + " cố rút " + amount + " nhưng chỉ có " + balance);
            return;
        }

        this.balance -= amount;

        // Log thông tin chi tiết giúp "Trace" (lần vết) dòng tiền khi cần Debugging [cite: 17]
        logger.info("Rút tiền THÀNH CÔNG. Số tiền: -" + amount + " | Số dư còn lại: " + this.balance);
    }

    public double getBalance() {
        return balance;
    }
}