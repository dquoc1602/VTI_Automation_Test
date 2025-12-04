package Polymorphism.Overriding;

public class OverrideA {
    int i, j;

    OverrideA(int a, int b) {
        i = a;
        j = b;
    }

    // This method will be overridden
    void show() {
        System.out.println("i và j: " + i + " " + j);
    }
}