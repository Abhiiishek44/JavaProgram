// Abstract class
abstract class Animal {
    
    // Abstract method
    abstract void sound();

    // Normal method
    void eat() {
        System.out.println("Animal is eating");
    }
}

// Subclass
class Dog extends Animal {

    // Implement abstract method
    void sound() {
        System.out.println("Dog barks");
    }
}

// Main class
public class Abstract9 {
    public static void main(String[] args) {

        Dog d = new Dog();

        d.sound(); // implemented method
        d.eat();   // inherited method
    }
}