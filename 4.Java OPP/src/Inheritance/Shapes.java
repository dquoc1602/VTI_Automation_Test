package Inheritance;

public class Shapes {
    public static void main(String[] args) {
        Triangle t1 = new Triangle();
        Triangle t2 = new Triangle();

        // Accessing inherited members (width, height)
        t1.width = 4.0;
        t1.height = 4.0;
        t1.style = "đặc";

        t2.width = 8.0;
        t2.height = 12.0;
        t2.style = "rỗng";

        System.out.println("Thông tin về đối tượng t1: ");
        t1.showStyle();
        t1.showDim(); // Inherited method
        System.out.println("Diện tích bằng " + t1.area());

        System.out.println();

        System.out.println("Thông tin về đối tượng t2: ");
        t2.showStyle();
        t2.showDim(); // Inherited method
        System.out.println("Diện tích bằng " + t2.area());
    }
}