 import java.util.Scanner;

public class ATMApp9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double balance = 1000; // initial balance
        int choice;

        do {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        System.out.println("Balance: " + balance);
                        break;

                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double deposit = sc.nextDouble();

                        if (deposit <= 0) {
                            throw new IllegalArgumentException("Invalid deposit amount");
                        }

                        balance += deposit;
                        System.out.println("Amount deposited successfully");
                        break;

                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdraw = sc.nextDouble();

                        if (withdraw <= 0) {
                            throw new IllegalArgumentException("Invalid withdrawal amount");
                        }

                        if (withdraw > balance) {
                            throw new ArithmeticException("Insufficient funds");
                        }

                        balance -= withdraw;
                        System.out.println("Withdrawal successful");
                        break;

                    case 4:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }

            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (Exception e) {
                System.out.println("Invalid input!");
                sc.nextLine(); // clear buffer

            } finally {
                System.out.println("Transaction processed.");
            }

        } while (choice != 4);

        sc.close();
    }
}