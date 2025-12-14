package space;

public class MainApp {
    public static void main(String[] args) {

        PaymentService payment = new PaymentService();
        SystemCore system = new SystemCore();

        // =========================================================================
        // KỊCH BẢN 1: MÔI TRƯỜNG PRODUCTION
        // Config: INFO
        // Mong đợi: Chỉ hiện INFO + WARN + ERROR
        // =========================================================================
        System.out.println("\n=== [SCENARIO 1] Config = INFO (Production) ===");
        SimLogger.currentConfigLevel = Level.INFO;

        payment.processPayment("UserA", 50000);
        payment.processPayment("Hacker", -50); // Lỗi — chỉ hiện ERROR


        // =========================================================================
        // KỊCH BẢN 2: CHỈ QUAN TÂM LỖI
        // Config: ERROR
        // Mong đợi: Chỉ hiện dòng màu đỏ
        // =========================================================================
        System.out.println("\n=== [SCENARIO 2] Config = ERROR (Chỉ lọc lỗi) ===");
        SimLogger.currentConfigLevel = Level.ERROR;

        payment.processPayment("UserB", 100000);          // INFO/WARN bị ẩn
        payment.processPayment("Attacker", -999999);      // Chỉ ERROR được in


        // =========================================================================
        // KỊCH BẢN 3: DEV DEBUG SQL, API
        // Config: DEBUG
        // Mong đợi: DEBUG + INFO + WARN + ERROR (nhưng ẩn TRACE)
        // =========================================================================
        System.out.println("\n=== [SCENARIO 3] Config = DEBUG (Fix Bug / Theo dõi SQL) ===");
        SimLogger.currentConfigLevel = Level.DEBUG;

        payment.processPayment("DevTester", 250000);
        payment.processPayment("testUser", 0); // WARN: giao dịch bằng 0


        // =========================================================================
        // KỊCH BẢN 4: TRUY VẤN LỖI KHÓ TÌM (TRACE)
        // Config: TRACE
        // Mong đợi: In toàn bộ log cực chi tiết
        // =========================================================================
        System.out.println("\n=== [SCENARIO 4] Config = TRACE (Điều tra lỗi khó) ===");
        SimLogger.currentConfigLevel = Level.TRACE;

        payment.processPayment("DebugMaster", 150000);
        payment.processPayment("GhostUser", -10); // TRACE + DEBUG + WARN + ERROR


        // =========================================================================
        // KỊCH BẢN 5: CẢNH BÁO HỆ THỐNG LÕI
        // Config: INFO
        // =========================================================================
        System.out.println("\n=== [SCENARIO 5] Hệ thống lõi gặp sự cố (Disk Error) ===");
        SimLogger.currentConfigLevel = Level.INFO;

        system.bootSystem();


        // =========================================================================
        // KỊCH BẢN 6: TEST LOAD / STRESS
        // Config: WARN
        // Mong đợi: Chỉ thấy WARN + ERROR
        // =========================================================================
        System.out.println("\n=== [SCENARIO 6] Config = WARN (Stress Test) ===");
        SimLogger.currentConfigLevel = Level.WARN;

        payment.processPayment("LoadTestUser", 30000);
        payment.processPayment("LoadTestUser", 1500000); // WARN: giao dịch lớn
        payment.processPayment("UserLoad", -1);          // ERROR vẫn thấy
    }
}
