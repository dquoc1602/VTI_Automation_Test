package Demo.EmployeeManagement;

public class Main {
    public static void main(String[] args) {
        // Tạo Manager
        Manager manager = new Manager("Alice", 35, Department.HR, 1000);
        manager.showInfo();

        System.out.println();

        // Tạo Developer
        Developer dev = new Developer("Bob", 28, Department.IT, 15);
        dev.showInfo();

        System.out.println();

        // Mảng nhân viên
        Employee[] employees = {manager, dev};

        System.out.println("Danh sách nhân viên:");
        for (Employee e : employees) {
            e.showInfo(); // Polymorphism: gọi calculateSalary() tương ứng class con
            System.out.println("-----");
        }
    }
}

