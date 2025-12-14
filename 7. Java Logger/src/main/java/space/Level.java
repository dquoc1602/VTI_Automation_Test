package space;

/**
 * Định nghĩa các cấp độ Log theo thứ tự từ thấp đến cao (0 -> 7).
 * Log4j hoạt động theo nguyên tắc: Chỉ in log nếu (Level Log >= Level Cấu hình).
 */
public enum Level {
    /**
     * TRACE (1) - Vết: Soi từng bước chạy nhỏ nhất.

     * 1. Cách sử dụng:
     * - Dùng logger.trace("message");
     * - Chi tiết hơn cả DEBUG. Nó ghi lại luồng chạy của thuật toán.

     * 2. Khi nào sử dụng:
     * - Khi bạn cần theo dõi từng biến đếm trong vòng lặp.
     * - Khi cần debug một thuật toán phức tạp mà DEBUG chưa đủ chi tiết.
     * - Lưu ý: Không bao giờ bật level này trên môi trường Production vì sẽ làm đầy ổ cứng rất nhanh.

     * 3. Ví dụ thực tế:
     * - "Bắt đầu vào vòng lặp for i = 0"
     * - "Giá trị tạm thời của biến temp = 15.5"
     * - "Method calculateTax() được gọi bắt đầu" / "Method calculateTax() kết thúc".
     */
    TRACE(1),

    /**
     * DEBUG (2) - Gỡ lỗi: Thông tin dành cho Developer.

     * 1. Cách sử dụng:
     * - Dùng logger.debug("message");
     * - Đây là level phổ biến nhất trong quá trình phát triển.

     * 2. Khi nào sử dụng:
     * - Khi cần in ra giá trị các tham số đầu vào và kết quả đầu ra của một hàm.
     * - Kiểm tra câu lệnh SQL được sinh ra từ Hibernate/JPA.
     * - Kiểm tra JSON request/response khi gọi API.

     * 3. Ví dụ thực tế:
     * - "User [ID: 101] đang thực hiện login với params: {username: 'vti'}"
     * - "Kết quả trả về từ DB: 0 records found."
     * - "Payload gửi đi API: { 'status': 'active' }"
     */
    DEBUG(2),

    /**
     * INFO (3) - Thông tin: Sự kiện vận hành bình thường.

     * 1. Cách sử dụng:
     * - Dùng logger.info("message");
     * - Dành cho SysAdmin hoặc Operator để biết hệ thống đang "sống" và làm việc gì.

     * 2. Khi nào sử dụng:
     * - Ghi lại các mốc sự kiện quan trọng trong luồng nghiệp vụ.
     * - Những thông tin khẳng định hệ thống hoạt động đúng.
     * - Thường được bật mặc định trên môi trường Production.

     * 3. Ví dụ thực tế:
     * - "Application started successfully on port 8080."
     * - "User [vti] đăng nhập thành công."
     * - "Đơn hàng #12345 đã được thanh toán hoàn tất."
     * - "Job gửi email marketing đã chạy xong lúc 08:00 AM."
     */
    INFO(3),

    /**
     * WARN (4) - Cảnh báo: Có vấn đề tiềm ẩn nhưng App vẫn chạy.

     * 1. Cách sử dụng:
     * - Dùng logger.warn("message");
     * - Báo hiệu một dấu hiệu bất thường nhưng chưa gây lỗi chức năng.

     * 2. Khi nào sử dụng:
     * - Khi sử dụng một API đã cũ.
     * - Khi tài nguyên hệ thống sắp chạm ngưỡng nhưng chưa đầy.
     * - Khi kết nối mạng bị chậm hoặc phải retry.
     * - Thiếu file config phụ.

     * 3. Ví dụ thực tế:
     * - "Disk usage is at 85%. Please cleanup soon."
     * - "Connection to Payment Gateway timed out. Retrying attempt 1/3..."
     * - "API getUserById() is deprecated, please use getUserDetail() instead."
     * - "Không tìm thấy file avatar của user, sử dụng avatar mặc định."
     */
    WARN(4),

    /**
     * ERROR (5) - Lỗi: Chức năng bị hỏng (Exceptions).

     * 1. Cách sử dụng:
     * - Dùng logger.error("message", exception);
     * - Báo hiệu một hành động của người dùng hoặc hệ thống đã thất bại.

     * 2. Khi nào sử dụng:
     * - Bắt buộc dùng trong try-catch.
     * - Khi kết nối Database thất bại hoặc API bị lỗi 500.
     * - Lỗi NullPointerException, IndexOutOfBoundsException...
     * - Ảnh hưởng đến một user hoặc một request nhưng hệ thống tổng thể vẫn chạy.

     * 3. Ví dụ thực tế:
     * - "Failed to save Order #123 to Database. Reason: Connection refused."
     * - "NullPointerException at PaymentService.java line 45."
     * - "User upload file thất bại do sai định dạng."
     */
    ERROR(5);



    private final int value;

    Level(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}