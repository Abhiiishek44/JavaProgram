import java.util.Scanner;

class Book {
    String name;
    boolean issued;

    static int totalBooks = 0; // static field

    // Constructor
    Book(String name) {
        this.name = name;
        this.issued = false;
        totalBooks++;
    }

    // Display book details
    void display() {
        System.out.println("Book: " + name + " | Issued: " + issued);
    }

    // Issue book
    void issueBook() {
        if (!issued) {
            issued = true;
            System.out.println(name + " issued successfully.");
        } else {
            System.out.println(name + " is already issued.");
        }
    }

    // Return book
    void returnBook() {
        if (issued) {
            issued = false;
            System.out.println(name + " returned successfully.");
        } else {
            System.out.println(name + " was not issued.");
        }
    }

    // Static method to show total books
    static void showTotalBooks() {
        System.out.println("Total books: " + totalBooks);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book[] books = new Book[5]; // simple fixed size
        int count = 0;
        int choice;

        do {
            System.out.println("\n1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Total Books");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    if (count < books.length) {
                        System.out.print("Enter book name: ");
                        String name = sc.nextLine();
                        books[count] = new Book(name);
                        count++;
                    } else {
                        System.out.println("Library is full.");
                    }
                    break;

                case 2:
                    for (int i = 0; i < count; i++) {
                        books[i].display();
                    }
                    break;

                case 3:
                    System.out.print("Enter book index to issue: ");
                    int i = sc.nextInt();
                    if (i >= 0 && i < count) {
                        books[i].issueBook();
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;

                case 4:
                    System.out.print("Enter book index to return: ");
                    int r = sc.nextInt();
                    if (r >= 0 && r < count) {
                        books[r].returnBook();
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;

                case 5:
                    Book.showTotalBooks(); // static method
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);

        sc.close();
    }
}