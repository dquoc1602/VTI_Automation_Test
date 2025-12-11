package Demo.EmployeeManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm nhân viên Manager");
            System.out.println("2. Thêm nhân viên Developer");
            System.out.println("3. Hiển thị tất cả nhân viên");
            System.out.println("4. Tính tổng lương");
            System.out.println("5. Lọc nhân viên theo phòng ban");
            System.out.println("6. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // đọc newline

            switch (choice) {
                case 1:
                    // Thêm Manager
                    System.out.print("Nhập tên: ");
                    String mName = scanner.nextLine();
                    System.out.print("Nhập tuổi: ");
                    int mAge = scanner.nextInt();
                    System.out.print("Nhập bonus: ");
                    double bonus = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Nhập phòng ban (HR, IT, SALES, FINANCE): ");
                    String mDept = scanner.nextLine();
                    employees.add(new Manager(mName, mAge, Department.valueOf(mDept.toUpperCase()), bonus));
                    break;

                case 2:
                    // Thêm Developer
                    System.out.print("Nhập tên: ");
                    String dName = scanner.nextLine();
                    System.out.print("Nhập tuổi: ");
                    int dAge = scanner.nextInt();
                    System.out.print("Nhập giờ OT: ");
                    int ot = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập phòng ban (HR, IT, SALES, FINANCE): ");
                    String dDept = scanner.nextLine();
                    employees.add(new Developer(dName, dAge, Department.valueOf(dDept.toUpperCase()), ot));
                    break;

                case 3:
                    // Hiển thị
                    if (employees.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        for (Employee e : employees) {
                            e.showInfo();
                            System.out.println("-----");
                        }
                    }
                    break;

                case 4:
                    // Tổng lương
                    double totalSalary = 0;
                    for (Employee e : employees) {
                        totalSalary += e.calculateSalary();
                    }
                    System.out.println("Tổng lương công ty: " + totalSalary);
                    break;

                case 5:
                    // Lọc theo phòng ban
                    System.out.print("Nhập phòng ban (HR, IT, SALES, FINANCE): ");
                    String dept = scanner.nextLine();
                    Department filterDept = Department.valueOf(dept.toUpperCase());
                    boolean found = false;
                    for (Employee e : employees) {
                        if (e.getDepartment() == filterDept) {
                            e.showInfo();
                            System.out.println("-----");
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không có nhân viên trong phòng ban này.");
                    }
                    break;

                case 6:
                    System.out.println("Thoát chương trình...");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 6);

        scanner.close();
    }
}

