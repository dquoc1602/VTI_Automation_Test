package Demo.StudentManagement;

import java.io.Serializable;

/**
 * Class cha truu tuong.
 * Khong the tao doi tuong truc tiep tu class nay.
 */
public abstract class Student implements Serializable {
    private static final long serialVersionUID = 1L; // Recommended for Serializable
    protected String id;
    protected String name;
    protected int age;

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Abstract method: Bat buoc lop con phai dinh nghia cach tinh diem
    public abstract double calculateGpa();

    public String getRank() {
        double gpa = calculateGpa();
        if (gpa >= 8.0) return "Gioi";
        if (gpa >= 6.5) return "Kha";
        if (gpa >= 5.0) return "Trung Binh";
        return "Yeu";
    }

    // Getters Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}