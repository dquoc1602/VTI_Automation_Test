package SuperKeyword;

public class B extends A {
    int i; // This 'i' hides the 'i' in class A

    B(int a, int b) {
        super.i = a; // Refers to 'i' in class A (parent)
        i = b;       // Refers to 'i' in class B (this class)
    }

    void show() {
        System.out.println("Thành viên i của lớp cha: " + super.i);
        System.out.println("Thành viên i của lớp con: " + i);
    }
}
