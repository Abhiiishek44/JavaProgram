import java.util.Scanner;

class Product {
    String name;
    double price;
    int quantity;

    // Default constructor
    Product() {
        name = "Unknown";
        price = 0;
        quantity = 0;
    }

    // Parameterized constructor
    Product(String n, double p, int q) {
        name = n;
        price = p;
        quantity = q;
    }

    double getTotal() {
        return price * quantity;
    }
}

public class EcommerceApp2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        Product[] products = new Product[n];
        double totalAmount = 0;

        // Input product details
        for (int i = 0; i < n; i++) {
            System.out.println("\nProduct " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.next();

            System.out.print("Enter price: ");
            double price = sc.nextDouble();

            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();

            products[i] = new Product(name, price, qty);
            totalAmount += products[i].getTotal();
        }

        // Apply discount
        double discount = 0;
        if (totalAmount > 1000) {
            discount = totalAmount * 0.10; // 10% discount
        }

        double finalAmount = totalAmount - discount;

        // Print invoice
        System.out.println("\n===== INVOICE =====");
        for (int i = 0; i < n; i++) {
            System.out.println(products[i].name + 
                               " | Price: " + products[i].price + 
                               " | Qty: " + products[i].quantity + 
                               " | Total: " + products[i].getTotal());
        }

        System.out.println("----------------------");
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Discount: " + discount);
        System.out.println("Final Amount: " + finalAmount);

        sc.close();
    }
}