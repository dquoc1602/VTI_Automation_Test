package Abstraction;

public class AbsTriangle extends AbsTwoDShape {
    String style;

    AbsTriangle() {
        super();
        style = "không xác định";
    }

    AbsTriangle(String s, double w, double h) {
        super(w, h, "hình tam giác");
        style = s;
    }

    AbsTriangle(double x) {
        super(x, "hình tam giác");
        style = "đặc";
    }

    // IMPLEMENTATION of the abstract method
    double area() {
        return getWidth() * getHeight() / 2;
    }

    void showStyle() {
        System.out.println("Tam giác " + style);
    }
}