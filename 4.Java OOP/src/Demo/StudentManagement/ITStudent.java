package Demo.StudentManagement;

public class ITStudent extends Student {
    private static final long serialVersionUID = 1L;
    private double javaScore;
    private double htmlScore;

    public ITStudent(String id, String name, int age, double javaScore, double htmlScore) {
        super(id, name, age);
        this.javaScore = javaScore;
        this.htmlScore = htmlScore;
    }

    // Ghi de phuong thuc tinh diem: (Java * 2 + HTML) / 3
    @Override
    public double calculateGpa() {
        return (2 * javaScore + htmlScore) / 3;
    }

    public double getJavaScore() { return javaScore; }
    public void setJavaScore(double javaScore) { this.javaScore = javaScore; }
    public double getHtmlScore() { return htmlScore; }
    public void setHtmlScore(double htmlScore) { this.htmlScore = htmlScore; }
}
