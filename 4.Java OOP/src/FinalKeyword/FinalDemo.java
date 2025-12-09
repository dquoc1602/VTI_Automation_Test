package FinalKeyword;

// Example 1: Preventing Method Overriding
class A {
    final void meth() {
        System.out.println("Đây là phương thức final.");
    }
}

class B extends A {
    // void meth() { // ERROR: Cannot override a final method
    //    System.out.println("Không hợp lệ.");
    // }
}

// Example 2: Preventing Inheritance
final class FinalClass {
    void methA() {
        System.out.println("Hello A");
    }
}

// class SubClass extends FinalClass { // ERROR: Cannot inherit from a final class
// }

public class FinalDemo {
    public static void main(String[] args) {
        B b = new B();
        b.meth(); // Can call it, but couldn't override it
    }
}