package FinalKeyword.Demo;

/**
 * Lớp FINAL (FINAL CLASS): SecurityKernel
 * * Ý nghĩa:
 * Khi một lớp được khai báo là 'final', KHÔNG lớp nào có thể kế thừa (extends) từ nó.
 * Điều này thường dùng cho các lớp chứa logic bảo mật quan trọng, các lớp tiện ích (String, Math...),
 * để ngăn chặn việc sửa đổi hành vi hoặc tấn công qua cơ chế kế thừa.
 */
public final class SecurityKernel {

    public void encryptData(String data) {
        System.out.println(">> [KERNEL] Đang mã hóa dữ liệu: " + data + " [SHA-256]");
    }

    public void decryptData(String hash) {
        System.out.println(">> [KERNEL] Đang giải mã dữ liệu...");
    }
}

// Nếu bạn cố gắng viết: "class HackKernel extends SecurityKernel { }" -> Sẽ bị lỗi biên dịch ngay lập tức.