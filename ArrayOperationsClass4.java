import java.util.Scanner;

class ArrayOps {
    int[] arr;
    int n;

    // Method to input array
    void input() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        n = sc.nextInt();

        arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    // Display array
    void display() {
        System.out.print("Array elements: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Find max, min, sum, average
    void calculate() {
        int max = arr[0];
        int min = arr[0];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
            sum += arr[i];
        }

        double avg = (double) sum / n;

        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);
    }

    // Search element
    void search() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                found = true;
                break;
            }
        }

        if (found)
            System.out.println("Element found");
        else
            System.out.println("Element not found");
    }
}

public class ArrayOperationsClass4 {
    public static void main(String[] args) {

        ArrayOps obj = new ArrayOps();

        obj.input();
        obj.display();
        obj.calculate();
        obj.search();
    }
}