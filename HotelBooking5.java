import java.util.Scanner;

public class HotelBooking5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int floors = 3;
        int rooms = 4;

        int[][] hotel = new int[floors][rooms]; // 0 = available, 1 = booked
        int choice;

        do {
            System.out.println("\n1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nRoom Status (0 = Available, 1 = Booked)");
                    for (int i = 0; i < floors; i++) {
                        System.out.print("Floor " + (i + 1) + ": ");
                        for (int j = 0; j < rooms; j++) {
                            System.out.print(hotel[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.print("Enter floor (1-" + floors + "): ");
                    int f = sc.nextInt() - 1;

                    System.out.print("Enter room (1-" + rooms + "): ");
                    int r = sc.nextInt() - 1;

                    if (f >= 0 && f < floors && r >= 0 && r < rooms) {
                        if (hotel[f][r] == 0) {
                            hotel[f][r] = 1;
                            System.out.println("Room booked successfully!");
                        } else {
                            System.out.println("Room already booked!");
                        }
                    } else {
                        System.out.println("Invalid room selection!");
                    }
                    break;

                case 3:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}