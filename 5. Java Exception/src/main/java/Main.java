import java.util.ArrayList;

// 1. Định nghĩa Ngoại lệ (Exception) Hợp Nhất

/**
 * Ngoại lệ chung được ném ra khi có bất kỳ lỗi nào liên quan đến việc kiểm tra số điện thoại (ví dụ: rỗng, ký tự không phải số, sai độ dài).
 */
class PhoneException extends Exception {
    // Constructor của ngoại lệ, chấp nhận một thông báo lỗi.
    public PhoneException(String message) {
        super(message); // Gọi constructor của lớp cha (Exception) để lưu thông báo lỗi.
    }
}

// 2. Lớp Chính chứa Logic Ứng Dụng
public class Main {

    // Phương thức main - Điểm bắt đầu của chương trình
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(); // Tạo danh sách để lưu các chuỗi kiểm thử.

        // Thêm các chuỗi kiểm thử:
        list.add("0788518002");      // Hợp lệ (10 chữ số)
        list.add("0123456789123");   // Không hợp lệ (quá dài) -> PhoneException
        list.add("0788518abc");      // Không hợp lệ (chứa chữ cái 'abc') -> PhoneException
        list.add("");                // Không hợp lệ (chuỗi rỗng) -> PhoneException

        // Lặp qua từng chuỗi số điện thoại trong danh sách
        for(String phone: list){
            try {
                // Hiển thị số đang được kiểm tra
                System.out.println("📞 Phone: " + phone);

                // Cố gắng gọi phương thức kiểm tra. Phương thức này sẽ ném ra PhoneException nếu không hợp lệ.
                validatePhone(phone);

                // Nếu không có Exception nào được ném ra, thông báo số điện thoại hợp lệ.
                System.out.println("✔ Số điện thoại hợp lệ!");
            }
            // Khối catch được đơn giản hóa để chỉ bắt duy nhất PhoneException
            catch (PhoneException e) {
                System.out.println("❌ Lỗi: " + e.getMessage());
            }
            // Khối finally luôn được thực thi, bất kể có Exception xảy ra hay không.
            finally {
                System.out.println();
                System.out.println("-------------------------------------------");
            }
        }
    }

    // 3. Phương thức Kiểm tra Hợp lệ

    /**
     * Phương thức kiểm tra một chuỗi có phải là số điện thoại hợp lệ (theo các quy tắc đã định).
     * Bây giờ chỉ ném ra một loại Exception duy nhất: PhoneException.
     * @param phone Chuỗi số điện thoại cần kiểm tra.
     * @throws PhoneException Nếu chuỗi rỗng, chứa ký tự không phải số, hoặc sai độ dài.
     */
    public static void validatePhone(String phone)
            throws PhoneException { // Chỉ khai báo ném PhoneException

        // Kiểm tra 1: Chuỗi rỗng
        // .trim() loại bỏ khoảng trắng ở đầu/cuối, .isEmpty() kiểm tra chuỗi rỗng.
        if (phone.trim().isEmpty()) {
            // Ném ngoại lệ PhoneException thay vì EmptyPhoneException.
            throw new PhoneException("Số điện thoại không được để trống!");
        }

        // Kiểm tra 2: Chỉ chứa chữ số
        // Regex: "\\d+" kiểm tra xem toàn bộ chuỗi có chỉ chứa một hoặc nhiều chữ số (0-9) hay không.
        if (!phone.matches("\\d+")) {
            // Ném ngoại lệ PhoneException thay vì NotNumberException.
            throw new PhoneException("Số điện thoại chỉ được chứa chữ số!");
        }

        // Kiểm tra 3: Độ dài 10
        if (phone.length() != 10) {
            // Ném ngoại lệ PhoneException thay vì LengthException.
            throw new PhoneException("Số điện thoại phải có 10 chữ số!");
        }

        // Nếu tất cả các kiểm tra đều thành công, phương thức kết thúc bình thường.
    }
}