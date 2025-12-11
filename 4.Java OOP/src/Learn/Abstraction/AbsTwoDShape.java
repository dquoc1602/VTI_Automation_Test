package Learn.Abstraction;

// ABSTRACT CLASS: Cannot be instantiated directly
public abstract class AbsTwoDShape {
    private double width;
    private double height;
    private String name;

    // Constructors
    AbsTwoDShape() {
        width = height = 0.0;
        name = "không xác định";
    }

    AbsTwoDShape(double w, double h, String n) {
        width = w;
        height = h;
        name = n;
    }

    AbsTwoDShape(double x, String n) {
        width = height = x;
        name = n;
    }

    // Getters and Setters
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public String getName() { return name; }

    public void setWidth(double w) { width = w; }
    public void setHeight(double h) { height = h; }

    void showDim() {
        System.out.println("Chiều dài cạnh đáy và chiều cao là " + width + " và " + height);
    }

    // ABSTRACT METHOD: No body. Subclasses MUST implement this.
    abstract double area();
}
