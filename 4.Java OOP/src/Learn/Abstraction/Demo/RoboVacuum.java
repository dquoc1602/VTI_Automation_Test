package Learn.Abstraction.Demo;

/**
 * Lớp con: RoboVacuum (Robot hút bụi)
 * Kế thừa từ lớp trừu tượng SmartDevice.
 */
public class RoboVacuum extends SmartDevice {

    private int batteryLevel;

    public RoboVacuum(String deviceName, int batteryLevel) {
        super(deviceName);
        this.batteryLevel = batteryLevel;
    }

    /**
     * Cài đặt chi tiết cho phương thức trừu tượng operate().
     * Ở đây, "hoạt động" có nghĩa là đi hút bụi.
     */
    @Override
    public void operate() {
        System.out.println(getDeviceName() + " bắt đầu dọn dẹp.");
        System.out.println("\t-> Quét bản đồ phòng.");
        System.out.println("\t-> Hút bụi với công suất mạnh.");
        System.out.println("\t-> Pin hiện tại: " + batteryLevel + "%");
    }
}