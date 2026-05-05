// Superclass
class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

// Subclass (inherits from Animal)
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

// Main class
public class SingleInheritance7 {
    public static void main(String[] args) {

        Dog d = new Dog();

        // Calling superclass method
        d.eat();

        // Calling subclass method
        d.bark();
    }
}