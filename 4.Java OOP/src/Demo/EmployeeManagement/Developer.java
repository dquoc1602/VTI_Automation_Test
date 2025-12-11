package Demo.EmployeeManagement;

public class Developer extends Employee {
    private int overtimeHours;

    public Developer(String name, int age, Department department, int overtimeHours) {
        super(name, age, department);
        this.overtimeHours = overtimeHours;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculateSalary() {
        return 4000 + overtimeHours * 20; // lương cơ bản + tiền OT
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Salary: " + calculateSalary());
    }
}

