package Learn.Abstraction.Demo;

/**
 * Lớp con: SecurityCamera (Camera an ninh)
 * Kế thừa từ lớp trừu tượng SmartDevice.
 */
public class SecurityCamera extends SmartDevice {

    private boolean nightMode;

    public SecurityCamera(String deviceName, boolean nightMode) {
        super(deviceName);
        this.nightMode = nightMode;
    }

    /**
     * Cài đặt chi tiết cho phương thức trừu tượng operate().
     * Ở đây, "hoạt động" có nghĩa là ghi hình và giám sát.
     */
    @Override
    public void operate() {
        System.out.println(getDeviceName() + " đang giám sát khu vực.");
        System.out.println("\t-> Đèn tín hiệu: XANH.");

        if (nightMode) {
            System.out.println("\t-> Đã bật chế độ hồng ngoại (Night Vision).");
        } else {
            System.out.println("\t-> Chế độ quay thường.");
        }
    }
}