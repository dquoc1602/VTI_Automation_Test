package Abstraction.Demo;

/**
 * Lớp trừu tượng: SmartDevice (Thiết bị thông minh)
 * * ĐẶC ĐIỂM CỦA TRỪU TƯỢNG (ABSTRACTION):
 * 1. Lớp này được khai báo là 'abstract', nghĩa là không thể tạo đối tượng trực tiếp từ nó.
 * (Ví dụ: không thể viết 'new SmartDevice()').
 * 2. Nó chứa các phương thức trừu tượng (abstract methods) - chỉ có tên hàm mà không có thân hàm.
 * 3. Nó đóng vai trò là một khuôn mẫu (template) cho các thiết bị cụ thể.
 */
public abstract class SmartDevice {

    private String deviceName;

    /**
     * Constructor của lớp cha.
     */
    public SmartDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    /**
     * Phương thức cụ thể (Concrete method):
     * Đây là chức năng chung mà mọi thiết bị đều có thể dùng ngay.
     */
    public void connectToWifi() {
        System.out.println("--- SYSTEM: " + deviceName + " đang kết nối tới Wifi gia đình... [OK]");
    }

    /**
     * PHƯƠNG THỨC TRỪU TƯỢNG (ABSTRACT METHOD): operate()
     * * Ý nghĩa: Mọi thiết bị thông minh đều phải biết "hoạt động".
     * Tuy nhiên, hoạt động như thế nào (hút bụi, bật đèn, quay phim...) thì lớp cha không biết.
     * Do đó, ta để nó là 'abstract' để bắt buộc các lớp con phải tự định nghĩa chi tiết.
     */
    public abstract void operate();
}
