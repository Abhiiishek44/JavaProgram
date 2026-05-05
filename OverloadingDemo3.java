class MathOperations {

    // Method overloading for power
    int power(int a, int b) {
        return (int) Math.pow(a, b);
    }

    double power(double a, double b) {
        return Math.pow(a, b);
    }

    // Method overloading for absolute value
    int absolute(int a) {
        return Math.abs(a);
    }

    double absolute(double a) {
        return Math.abs(a);
    }
}

public class OverloadingDemo3 {
    public static void main(String[] args) {

        MathOperations obj = new MathOperations();

        // Power
        System.out.println("Power (int): " + obj.power(2, 3));
        System.out.println("Power (double): " + obj.power(2.5, 2));

        // Absolute
        System.out.println("Absolute (int): " + obj.absolute(-10));
        System.out.println("Absolute (double): " + obj.absolute(-5.7));
    }
}