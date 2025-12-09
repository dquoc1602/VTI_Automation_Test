package SuperKeyword.Demo;

/**
 * Lớp cha: RoomBooking (Đặt phòng tiêu chuẩn)
 * Đại diện cho logic đặt phòng cơ bản nhất.
 */
public class RoomBooking {

    protected String guestName;
    protected int nights;
    protected double baseRate; // Giá phòng cơ bản mỗi đêm

    /**
     * Constructor của lớp cha.
     */
    public RoomBooking(String guestName, int nights, double baseRate) {
        this.guestName = guestName;
        this.nights = nights;
        this.baseRate = baseRate;
        System.out.println("-> [INFO] Đã khởi tạo đặt phòng cơ bản cho: " + guestName);
    }

    /**
     * Phương thức tính tổng tiền cơ bản.
     */
    public double calculateTotal() {
        return nights * baseRate;
    }

    /**
     * Hiển thị thông tin hóa đơn.
     */
    public void showBill() {
        System.out.println("=== HÓA ĐƠN TIÊU CHUẨN ===");
        System.out.println("Khách hàng: " + guestName);
        System.out.println("Số đêm: " + nights);
        System.out.println("Đơn giá: " + baseRate + "$/đêm");
        System.out.println("Tổng tiền phòng: " + calculateTotal() + "$");
    }
}
