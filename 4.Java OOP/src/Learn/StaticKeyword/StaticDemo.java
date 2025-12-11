package Learn.StaticKeyword;

public class StaticDemo {
    int x; // Normal instance variable

    // STATIC VARIABLE: Shared by all instances of the class
    static int y;

    // Static method can access static variables directly
    int sum() {
        return x + y;
    }
}
