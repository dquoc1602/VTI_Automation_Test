package Demo.EmployeeManagement;

public class Employee {
    // Thuộc tính
    private String name;
    private int age;
    private Department department;

    // Constructor
    public Employee(String name, int age, Department department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    // Getter và Setter (Encapsulation)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // Method
    public void showInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Department: " + department);
    }

    // Polymorphism: method calculateSalary
    public double calculateSalary() {
        return 0;
    }
}

