import java.util.Scanner;

public class SimpleCalculatorSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            try {
                System.out.print("Enter first number: ");
                double a = sc.nextDouble();

                System.out.print("Enter operator (+, -, *, /): ");
                char op = sc.next().charAt(0);

                System.out.print("Enter second number: ");
                double b = sc.nextDouble();

                double result = 0;

                // Switch-case logic
                switch (op) {
                    case '+':
                        result = a + b;
                        System.out.println("Result: " + result);
                        break;

                    case '-':
                        result = a - b;
                        System.out.println("Result: " + result);
                        break;

                    case '*':
                        result = a * b;
                        System.out.println("Result: " + result);
                        break;

                    case '/':
                        if (b == 0) {
                            System.out.println("Error: Cannot divide by zero");
                        } else {
                            result = a / b;
                            System.out.println("Result: " + result);
                        }
                        break;

                    default:
                        System.out.println("Invalid operator");
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                sc.nextLine(); // clear buffer
            }

            // Loop control
            System.out.print("Do you want to continue? (y/n): ");
            choice = sc.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');

        System.out.println("Calculator closed.");
        sc.close();
    }
}