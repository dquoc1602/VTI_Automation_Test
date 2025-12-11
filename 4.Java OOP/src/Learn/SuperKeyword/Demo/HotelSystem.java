package Learn.SuperKeyword.Demo;

/**
 * Lớp chính: HotelSystem
 * Chạy chương trình để kiểm chứng từ khóa super.
 */
public class HotelSystem {

    public static void main(String[] args) {
        System.out.println("========= QUẢN LÝ KHÁCH SẠN =========");

        /**
         * Trường hợp 1: Khách đặt phòng thường.
         */
        System.out.println("\n1. Tạo Booking thường:");
        RoomBooking normalRoom = new RoomBooking("Nguyen Van A", 3, 100);
        normalRoom.showBill();

        /**
         * Trường hợp 2: Khách đặt phòng VIP (Suite).
         * Khi khởi tạo, nó sẽ gọi Constructor của RoomBooking trước (do dòng super(...)).
         */
        System.out.println("\n2. Tạo Booking VIP:");
        // Giá phòng 200$, phí dịch vụ thêm 50$
        SuiteBooking vipRoom = new SuiteBooking("Tran Thi B", 2, 200, 50);

        /**
         * Khi gọi showBill():
         * Nó sẽ chạy code trong SuiteBooking.
         * Trong đó, dòng super.showBill() sẽ in ra phần đầu của hóa đơn.
         * Sau đó mới in tiếp phần phí dịch vụ.
         */
        System.out.println("\n--- Chi tiết hóa đơn VIP ---");
        vipRoom.showBill();
    }
}