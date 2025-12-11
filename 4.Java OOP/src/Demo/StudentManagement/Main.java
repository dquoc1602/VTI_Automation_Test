package Demo.StudentManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        // 1. Load du lieu cu
        manager.loadFromFile();

        // 2. Tao du lieu mau neu danh sach trong
        manager.generateMockData();

        while (true) {
            System.out.println("\n==========================================");
            System.out.println("    QUAN LY SINH VIEN (ENTERPRISE)");
            System.out.println("==========================================");
            System.out.println("1. Them sinh vien (IT / Biz)");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tim kiem sinh vien");
            System.out.println("4. Sap xep theo GPA");
            System.out.println("5. Xoa sinh vien");
            System.out.println("6. Luu du lieu");
            System.out.println("0. Thoat");
            System.out.println("==========================================");
            System.out.print("Chon chuc nang: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1": manager.addStudent(); break;
                case "2": manager.displayAll(); break;
                case "3": manager.searchStudent(); break;
                case "4": manager.sortByGpa(); break;
                case "5": manager.deleteStudent(); break;
                case "6": manager.saveToFile(); break;
                case "0":
                    manager.saveToFile();
                    System.out.println("Bye!");
                    System.exit(0);
                default: System.out.println("(!) Chon sai, vui long chon lai!");
            }

            // 3. Them thoi gian doi (Delay) de quan sat
            pause();
        }
    }

    /**
     * Ham tam dung chuong trinh trong giay lat
     */
    private static void pause() {
        try {
            System.out.print("\n...Dang cho 5 giay de ban xem ket qua...");
            Thread.sleep(5000); // Dung 5000 miliseconds (5 giay)
            System.out.println(); // Xuong dong cho thoang
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}