package Polymorphism.Overloading;

public class Overload {

    // First version: No parameters
    void ovlDemo() {
        System.out.println("Không có tham số");
    }

    // Overloaded version: One integer parameter
    void ovlDemo(int a) {
        System.out.println("Có một tham số: " + a);
    }

    // Overloaded version: Two integer parameters
    int ovlDemo(int a, int b) {
        System.out.println("Có hai tham số: " + a + " " + b);
        return a + b;
    }

    // Overloaded version: Two double parameters
    double ovlDemo(double a, double b) {
        System.out.println("Có hai tham số kiểu double: " + a + " " + b);
        return a + b;
    }
}
