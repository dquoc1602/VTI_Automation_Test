package Learn.StaticKeyword;

public class SDemo {
    public static void main(String[] args) {
        StaticDemo ob1 = new StaticDemo();
        StaticDemo ob2 = new StaticDemo();

        ob1.x = 10;
        ob2.x = 20;

        System.out.println("Tất nhiên, ob1.x và ob2.x là các biến độc lập.");
        System.out.println("ob1.x: " + ob1.x + "\nob2.x: " + ob2.x);
        System.out.println();

        // Accessing static variable directly via Class Name (Recommended)
        System.out.println("Biến tĩnh y được dùng chung");
        StaticDemo.y = 19;

        System.out.println("Thiết lập StaticDemo.y = 19");
        System.out.println("ob1.sum(): " + ob1.sum()); // 10 + 19
        System.out.println("ob2.sum(): " + ob2.sum()); // 20 + 19
        System.out.println();

        StaticDemo.y = 100;
        System.out.println("Thay đổi giá trị StaticDemo.y = 100");
        System.out.println("ob1.sum(): " + ob1.sum()); // 10 + 100
        System.out.println("ob2.sum(): " + ob2.sum()); // 20 + 100
    }
}