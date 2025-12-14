package banking;

/**
 * Class chính để chạy chương trình giả lập.
 */
public class Main {

    public static void main(String[] args) {

        // 1. Nhược điểm của System.out.println:
        // Dòng này chỉ hiện ở màn hình console, khi tắt app sẽ mất, không tra cứu lại được[cite: 99].
        System.out.println("--- BẮT ĐẦU HỆ THỐNG NGÂN HÀNG ---");

        // 2. Bắt đầu kịch bản test Log

        // Tạo tài khoản (Sẽ sinh log INFO trong file banking.log)
        BankAccount myAccount = new BankAccount("Nguyen Van A", 5000000);

        // Thực hiện giao dịch nạp tiền thành công
        myAccount.deposit(2000000);

        // Thử nạp số tiền âm (Sẽ sinh log ERROR)
        myAccount.deposit(-50000);

        // Thực hiện rút tiền thành công
        myAccount.withdraw(1000000);

        // Thử rút quá số dư (Sẽ sinh log WARN)
        myAccount.withdraw(10000000);

        // 3. Kết thúc
        System.out.println("--- KẾT THÚC GIAO DỊCH ---");

        /**
         * HƯỚNG DẪN KIỂM TRA KẾT QUẢ:
         * 1. Nhìn vào Console để thấy log ngay lập tức.
         * 2. Mở file 'logs/banking.log' trong project folder để thấy log được lưu trữ[cite: 369, 416].
         * File này sẽ chứa cả thời gian, tên luồng (main), và dòng code sinh ra log.
         */
    }
}
