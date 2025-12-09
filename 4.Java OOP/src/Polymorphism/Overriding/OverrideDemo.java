package Polymorphism.Overriding;

public class OverrideDemo {
    public static void main(String[] args) {
        OverrideB subOb = new OverrideB(1, 2, 3);

        // This calls show() in OverrideB, not OverrideA
        subOb.show();
    }
}
