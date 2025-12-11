package Learn.Polymorphism.Overriding;

public class OverrideB extends OverrideA {
    int k;

    OverrideB(int a, int b, int c) {
        super(a, b);
        k = c;
    }

    // OVERRIDING: This method replaces the version in OverrideA for objects of type OverrideB
    @Override
    void show() {
        System.out.println("k: " + k);
    }
}
