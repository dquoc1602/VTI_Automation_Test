package Demo.StudentManagement;

public class BizStudent extends Student {
    private static final long serialVersionUID = 1L;
    private double marketingScore;
    private double salesScore;

    public BizStudent(String id, String name, int age, double marketingScore, double salesScore) {
        super(id, name, age);
        this.marketingScore = marketingScore;
        this.salesScore = salesScore;
    }

    // Ghi de phuong thuc tinh diem: (Marketing * 2 + Sales) / 3
    @Override
    public double calculateGpa() {
        return (2 * marketingScore + salesScore) / 3;
    }

    public double getMarketingScore() { return marketingScore; }
    public void setMarketingScore(double marketingScore) { this.marketingScore = marketingScore; }
    public double getSalesScore() { return salesScore; }
    public void setSalesScore(double salesScore) { this.salesScore = salesScore; }
}