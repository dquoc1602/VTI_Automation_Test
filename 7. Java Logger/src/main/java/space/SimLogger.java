package space;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class này mô phỏng thư viện Log4j hoặc SLF4J.
 * Nhiệm vụ: Nhận thông điệp từ code -> Kiểm tra Level -> In ra màn hình có màu sắc.
 */
public class SimLogger {
    // Biến tĩnh (static) dùng chung cho toàn bộ dự án.
    // Thay đổi biến này sẽ ảnh hưởng đến việc in log của TẤT CẢ các file khác.
    public static Level currentConfigLevel = Level.INFO;

    private String className;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");

    // Các mã màu ANSI để in log đẹp mắt hơn trên Console
    private static final String RESET = "\u001B[0m";
    private static final String GREY = "\u001B[90m";   // Trace
    private static final String CYAN = "\u001B[36m";   // Debug
    private static final String GREEN = "\u001B[32m";  // Info
    private static final String YELLOW = "\u001B[33m"; // Warn
    private static final String RED = "\u001B[31m";    // Error
    private static final String RED_BOLD = "\u001B[1;41;37m"; // Fatal

    public SimLogger(Class<?> clazz) {
        this.className = clazz.getSimpleName();
    }

    /**
     * LOGIC QUAN TRỌNG NHẤT: BỘ LỌC (FILTER)
     * Chỉ in ra nếu Level của tin nhắn >= Level đang cấu hình.
     */
    private void log(Level messageLevel, String msg, String color) {
        if (messageLevel.getValue() >= currentConfigLevel.getValue()) {
            System.out.println(color
                    + String.format("[%-5s] %s [%s] - %s", messageLevel, sdf.format(new Date()), className, msg)
                    + RESET);
        }
    }

    // --- Các hàm tiện ích để gọi log nhanh ---

    public void trace(String msg) { log(Level.TRACE, msg, GREY); }
    public void debug(String msg) { log(Level.DEBUG, msg, CYAN); }
    public void info(String msg) { log(Level.INFO, msg, GREEN); }
    public void warn(String msg) { log(Level.WARN, msg, YELLOW); }
    public void error(String msg) { log(Level.ERROR, msg, RED); }
}