package Demo.StudentManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentManager {
    private ArrayList<Student> students;
    private Scanner scanner;
    private final String FILE_NAME = "students.dat";

    public StudentManager() {
        this.students = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // === MOI: Ham tao du lieu mac dinh ===
    public void generateMockData() {
        if (!students.isEmpty()) return; // Chi tao neu danh sach trong

        students.add(new ITStudent("IT01", "Nguyen Van A", 20, 8.5, 7.0));
        students.add(new BizStudent("BZ01", "Tran Thi B", 19, 7.0, 8.0));
        students.add(new ITStudent("IT02", "Le Van C", 22, 5.0, 6.0));
        students.add(new BizStudent("BZ02", "Pham Van D", 21, 9.0, 9.5));

        System.out.println(">> Da khoi tao du lieu mau san co!");
    }
    // =====================================

    // 1. Them sinh vien
    public void addStudent() {
        System.out.println("\n--- THEM SINH VIEN MOI ---");
        System.out.println("1. Sinh vien IT");
        System.out.println("2. Sinh vien Kinh te (Biz)");
        System.out.print("Chon loai sinh vien (1/2): ");
        String type = scanner.nextLine();

        String id;
        while (true) {
            System.out.print("Nhap ID: ");
            id = scanner.nextLine().trim();
            if (findById(id) == null && !id.isEmpty()) break;
            System.out.println("(!) ID da ton tai hoac khong hop le.");
        }

        System.out.print("Nhap ten: ");
        String name = scanner.nextLine().trim();

        int age = 0;
        try {
            System.out.print("Nhap tuoi: ");
            age = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("(!) Tuoi mac dinh la 18 do nhap sai.");
            age = 18;
        }

        if (type.equals("1")) {
            double java = inputScore("Diem Java");
            double html = inputScore("Diem HTML");
            students.add(new ITStudent(id, name, age, java, html));
        } else {
            double mar = inputScore("Diem Marketing");
            double sales = inputScore("Diem Sales");
            students.add(new BizStudent(id, name, age, mar, sales));
        }
        System.out.println(">> Them thanh cong!");
    }

    private double inputScore(String prompt) {
        while(true) {
            try {
                System.out.print(prompt + ": ");
                double score = Double.parseDouble(scanner.nextLine().trim());
                if(score >= 0 && score <= 10) return score;
                System.out.println("(!) Diem phai tu 0-10.");
            } catch (Exception e) {
                System.out.println("(!) Nhap so khong hop le.");
            }
        }
    }

    // 2. Hien thi
    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("\n(!) Danh sach trong.");
            return;
        }
        System.out.println("\n-----------------------------------------------------------------------------------");
        System.out.printf("| %-8s | %-20s | %-12s | %-6s | %-6s | %-10s |\n", "ID", "HO TEN", "NGANH", "GPA", "RANK", "INFO");
        System.out.println("-----------------------------------------------------------------------------------");
        for (Student s : students) {
            String type = (s instanceof ITStudent) ? "IT" : "Biz";
            String info = (s instanceof ITStudent)
                    ? "J:" + ((ITStudent)s).getJavaScore()
                    : "M:" + ((BizStudent)s).getMarketingScore();

            System.out.printf("| %-8s | %-20s | %-12s | %-6.2f | %-6s | %-10s |\n",
                    s.getId(), s.getName(), type, s.calculateGpa(), s.getRank(), info);
        }
        System.out.println("-----------------------------------------------------------------------------------");
    }

    public void searchStudent() {
        System.out.print("Nhap ID tim kiem: ");
        String id = scanner.nextLine();
        Student s = findById(id);
        if(s != null) {
            System.out.println(">> Tim thay: " + s.getName() + " - GPA: " + String.format("%.2f", s.calculateGpa()));
        } else {
            System.out.println("(!) Khong tim thay.");
        }
    }

    public void sortByGpa() {
        Collections.sort(students, (s1, s2) -> Double.compare(s2.calculateGpa(), s1.calculateGpa()));
        System.out.println(">> Da sap xep!");
        displayAll();
    }

    public void deleteStudent() {
        System.out.print("Nhap ID can xoa: ");
        String id = scanner.nextLine();
        Student s = findById(id);
        if (s != null) {
            students.remove(s);
            System.out.println(">> Da xoa " + s.getName());
        } else {
            System.out.println("(!) Khong tim thay ID.");
        }
    }

    // 6. Luu file
    public void saveToFile() {
        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
            System.out.println(">> Da luu du lieu vao " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("(!) Loi khi luu file: " + e.getMessage());
        }
    }

    // 7. Doc file
    @SuppressWarnings("unchecked")
    public void loadFromFile() {
        try {
            File f = new File(FILE_NAME);
            if (!f.exists()) return;
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (ArrayList<Student>) ois.readObject();
            ois.close();
            fis.close();
            System.out.println(">> Da load " + students.size() + " sinh vien tu file.");
        } catch (Exception e) {
            System.out.println("(!) Loi doc file (co the do file rong hoac cu): " + e.getMessage());
        }
    }

    private Student findById(String id) {
        for (Student s : students) if (s.getId().equalsIgnoreCase(id)) return s;
        return null;
    }
}