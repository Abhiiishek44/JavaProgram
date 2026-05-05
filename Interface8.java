// Interface
interface Shape {
    void draw();
}

// Class 1
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

// Class 2
class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

// Main class
public class Interface8 {
    public static void main(String[] args) {

        Shape s; // interface reference

        // Polymorphism
        s = new Circle();
        s.draw();

        s = new Rectangle();
        s.draw();
    }
}