package Demo.EmployeeManagement;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, int age, Department department, double bonus) {
        super(name, age, department);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return 5000 + bonus; // lương cơ bản + thưởng
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Salary: " + calculateSalary());
    }
}

