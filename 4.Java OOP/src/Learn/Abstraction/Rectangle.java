package Learn.Abstraction;

public class Rectangle extends AbsTwoDShape {

    Rectangle() {
        super();
    }

    Rectangle(double w, double h) {
        super(w, h, "hình chữ nhật");
    }

    Rectangle(double x) {
        super(x, "hình chữ nhật");
    }

    // IMPLEMENTATION of the abstract method logic specific to Rectangle
    double area() {
        return getWidth() * getHeight();
    }

    boolean isSquare() {
        return getWidth() == getHeight();
    }
}
