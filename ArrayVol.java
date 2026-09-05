import java.util.Scanner;

public class ArrayVol {
    public static int calculateWater(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int n = arr.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int minWallHeight = Math.min(leftMax[i], rightMax[i]);
            totalWater += minWallHeight - arr[i];
        }

        return totalWater;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of walls: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Total water trapped: 0 units");
            scanner.close();
            return;
        }

        int[] arr = new int[n];

        System.out.println("Enter the heights of the walls separated by spaces:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int result = calculateWater(arr);
        System.out.println("Total water trapped: " + result + " units");

        scanner.close();
    }
}
