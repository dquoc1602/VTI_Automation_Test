package Abstraction;

public class AbsShape {
    public static void main(String[] args) {
        // AbsTwoDShape shape = new AbsTwoDShape(); // Error! Cannot instantiate abstract class

        AbsTwoDShape shapes[] = new AbsTwoDShape[4];

        shapes[0] = new AbsTriangle("rỗng", 8.0, 12.0);
        shapes[1] = new Rectangle(10);
        shapes[2] = new Rectangle(10, 4);
        shapes[3] = new AbsTriangle(7.0);

        for (AbsTwoDShape shape : shapes) {
            System.out.println("Đối tượng là: " + shape.getName());
            // Polymorphism in action: calls the correct area() for the specific object type
            System.out.println("Diện tích bằng " + shape.area());
            System.out.println();
        }
    }
}
