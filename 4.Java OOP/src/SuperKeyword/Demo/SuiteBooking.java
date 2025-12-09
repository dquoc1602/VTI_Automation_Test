package SuperKeyword.Demo;

/**
 * Lớp con: SuiteBooking (Đặt phòng Hạng Sang/VIP)
 * Kế thừa từ RoomBooking và sử dụng từ khóa 'super' để mở rộng tính năng.
 */
public class SuiteBooking extends RoomBooking {

    private double serviceFee; // Phí dịch vụ thêm (Spa, Minibar...)

    /**
     * Constructor của lớp con.
     * Sử dụng super(...) để gọi Constructor lớp cha.
     */
    public SuiteBooking(String guestName, int nights, double baseRate, double serviceFee) {
        /**
         * SỬ DỤNG SUPER CHO CONSTRUCTOR:
         * super(...) phải là dòng lệnh ĐẦU TIÊN trong constructor của lớp con.
         * Nó giúp đẩy dữ liệu lên lớp cha để xử lý các thuộc tính chung (guestName, nights, baseRate).
         */
        super(guestName, nights, baseRate);

        this.serviceFee = serviceFee;
        System.out.println("-> [INFO] Đã nâng cấp lên gói Suite VIP.");
    }

    /**
     * @Override
     * Ghi đè phương thức tính tiền để cộng thêm phí dịch vụ.
     */
    @Override
    public double calculateTotal() {
        /**
         * SỬ DỤNG SUPER ĐỂ GỌI PHƯƠNG THỨC LỚP CHA:
         * Thay vì viết lại công thức (nights * baseRate), ta gọi super.calculateTotal()
         * để lấy kết quả tính toán gốc, sau đó cộng thêm phí riêng của lớp con.
         */
        double basePrice = super.calculateTotal();
        return basePrice + serviceFee;
    }

    /**
     * @Override
     * Ghi đè phương thức hiển thị hóa đơn để thêm thông tin VIP.
     */
    @Override
    public void showBill() {
        /**
         * Tái sử dụng logic hiển thị của lớp cha (In tên, số đêm, giá phòng...).
         * Nếu không có super.showBill(), ta sẽ phải System.out.println lại từ đầu.
         */
        super.showBill();

        // Thêm phần hiển thị riêng của lớp con
        System.out.println("--- DỊCH VỤ VIP ---");
        System.out.println("Phí dịch vụ thêm (Spa/Bar): " + serviceFee + "$");
        System.out.println("=> TỔNG CỘNG THANH TOÁN: " + this.calculateTotal() + "$");
        System.out.println("==========================");
    }
}