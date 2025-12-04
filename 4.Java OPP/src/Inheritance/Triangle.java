package Inheritance;

// INHERITANCE: Triangle inherits everything from TwoDShape using 'extends'
public class Triangle extends TwoDShape {

    String style;

    // Method specific to Triangle
    double area() {
        // Can access width and height because they are inherited from TwoDShape
        return width * height / 2;
    }

    void showStyle() {
        System.out.println("Tam giác " + style);
    }
}