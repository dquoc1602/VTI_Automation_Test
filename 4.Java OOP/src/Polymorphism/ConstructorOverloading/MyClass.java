package Polymorphism.ConstructorOverloading;

public class MyClass {
    int x;

    // Constructor 1: No arguments
    MyClass() {
        System.out.println("Bên trong phương thức MyClass().");
        x = 0;
    }

    // Constructor 2: One integer argument
    MyClass(int i) {
        System.out.println("Bên trong phương thức MyClass(int).");
        x = i;
    }

    // Constructor 3: One double argument
    MyClass(double d) {
        System.out.println("Bên trong phương thức MyClass(double).");
        x = (int) d;
    }

    // Constructor 4: Two integer arguments
    MyClass(int i, int j) {
        System.out.println("Bên trong phương thức MyClass(int, int).");
        x = i * j;
    }
}
