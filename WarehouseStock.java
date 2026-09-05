import java.util.Scanner;

public class WarehouseStock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        int[] stock = new int[n];

        // Read stock quantities
        System.out.println("Enter stock quantity for each product:");
        for (int i = 0; i < n; i++) {
            System.out.print("Product " + (i + 1) + ": ");
            stock[i] = sc.nextInt();
        }

        int sum = 0;
        int maxIndex = 0;
        int minIndex = 0;
        int reorderCount = 0;

        for (int i = 0; i < n; i++) {
            sum += stock[i];

            if (stock[i] > stock[maxIndex]) {
                maxIndex = i;
            }

            if (stock[i] < stock[minIndex]) {
                minIndex = i;
            }

            // products needing reorder
            if (stock[i] < 20) {
                reorderCount++;
            }
        }

        double average = (double) sum / n;

        System.out.println("\n--- Warehouse Stock Report ---");
        System.out.println("Total items in stock: " + sum);
        System.out.println("Average stock per product: " + average);
        System.out.println("Product with maximum stock: Product " + (maxIndex + 1) + " (" + stock[maxIndex] + " items)");
        System.out.println("Product with minimum stock: Product " + (minIndex + 1) + " (" + stock[minIndex] + " items)");
        System.out.println("Number of products needing reorder: " + reorderCount);

        System.out.println("Products number needing reorder:");
        for (int i = 0; i < n; i++) {
            if (stock[i] < 20) {
                System.out.println("Product " + (i + 1) + " - Stock: " + stock[i]);
            }
        }

        sc.close();
    }
}
