import java.util.Scanner;

public class ShoppingApp12 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double total = 0;
        int choice;

        do {
            System.out.println("\n1. Add Item");
            System.out.println("2. View Total");
            System.out.println("3. Make Payment");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Enter item price: ");
                        double price = Double.parseDouble(sc.nextLine());

                        if (price < 0) {
                            throw new ArithmeticException("Price cannot be negative");
                        }

                        total += price;
                        System.out.println("Item added to cart");
                        break;

                    case 2:
                        System.out.println("Total Price: " + total);
                        break;

                    case 3:
                        System.out.print("Enter payment amount: ");
                        double payment = Double.parseDouble(sc.nextLine());

                        if (payment < total) {
                            throw new ArithmeticException("Insufficient payment");
                        }

                        double change = payment - total;
                        System.out.println("Payment successful");
                        System.out.println("Change: " + change);
                        total = 0; // reset cart
                        break;

                    case 4:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input (enter numbers only)");

            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (Exception e) {
                System.out.println("Unexpected error");

            } finally {
                System.out.println("Operation completed.");
            }

        } while (true);
    }
}