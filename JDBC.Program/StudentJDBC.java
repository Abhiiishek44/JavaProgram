import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb"; // change if needed
    private static final String USER = "root"; // change if needed
    private static final String PASS = "password"; // change if needed

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             Connection connection = DriverManager.getConnection(URL, USER, PASS)) {

            connection.setAutoCommit(false); // transaction handling

            int choice;
            do {
                printMenu();
                choice = readInt(scanner, "Enter choice: ");

                try {
                    switch (choice) {
                        case 1:
                            addStudent(connection, scanner);
                            connection.commit();
                            System.out.println("Student added.");
                            break;
                        case 2:
                            viewStudents(connection);
                            break;
                        case 3:
                            updateStudent(connection, scanner);
                            connection.commit();
                            System.out.println("Student updated.");
                            break;
                        case 4:
                            deleteStudent(connection, scanner);
                            connection.commit();
                            System.out.println("Student deleted.");
                            break;
                        case 5:
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                } catch (SQLException ex) {
                    connection.rollback();
                    System.out.println("Operation failed. Rolled back. Error: " + ex.getMessage());
                }
            } while (choice != 5);
        } catch (SQLException ex) {
            System.out.println("Database connection failed: " + ex.getMessage());
        }
    }

    private static void printMenu() {
        System.out.println("\n1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
    }

    private static void addStudent(Connection connection, Scanner scanner) throws SQLException {
        int id = readInt(scanner, "Enter ID: ");
        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();
        double marks = readDouble(scanner, "Enter Marks: ");

        String insert = "INSERT INTO students (id, name, marks) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insert)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setDouble(3, marks);
            statement.executeUpdate();
        }
    }

    private static void viewStudents(Connection connection) throws SQLException {
        String select = "SELECT id, name, marks FROM students ORDER BY id";
        try (PreparedStatement statement = connection.prepareStatement(select);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " +
                        resultSet.getString("name") + " " +
                        resultSet.getDouble("marks"));
            }
        }
    }

    private static void updateStudent(Connection connection, Scanner scanner) throws SQLException {
        int id = readInt(scanner, "Enter ID to update: ");
        double marks = readDouble(scanner, "Enter new marks: ");

        String update = "UPDATE students SET marks = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(update)) {
            statement.setDouble(1, marks);
            statement.setInt(2, id);
            statement.executeUpdate();
        }
    }

    private static void deleteStudent(Connection connection, Scanner scanner) throws SQLException {
        int id = readInt(scanner, "Enter ID to delete: ");

        String delete = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(delete)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
