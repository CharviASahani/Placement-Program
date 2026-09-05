import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take array size from user
        System.out.print("Enter number of walls: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Take array elements from user
        System.out.println("Enter the height of each wall:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Arrays for maximum wall on left and right
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Build leftMax array
        leftMax[0] = arr[0];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        // Build rightMax array
        rightMax[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        // Calculate total water
        int totalWater = 0;

        // Store water at each position
        int[] water = new int[n];

        for (int i = 0; i < n; i++) {

            int minWall = Math.min(leftMax[i], rightMax[i]);

            water[i] = minWall - arr[i];

            totalWater += water[i];
        }

        // Print arrays
        System.out.println("\nArray       : " + Arrays.toString(arr));
        System.out.println("Left Max    : " + Arrays.toString(leftMax));
        System.out.println("Right Max   : " + Arrays.toString(rightMax));
        System.out.println("Water       : " + Arrays.toString(water));

        // Total water
        System.out.println("\nTotal water stored = " + totalWater + " units");

        // Find 2 positions containing the highest amount of water
        int firstIndex = -1;
        int secondIndex = -1;

        int firstWater = -1;
        int secondWater = -1;

        for (int i = 0; i < n; i++) {

            if (water[i] > firstWater) {

                secondWater = firstWater;
                secondIndex = firstIndex;

                firstWater = water[i];
                firstIndex = i;

            } else if (water[i] > secondWater) {

                secondWater = water[i];
                secondIndex = i;
            }
        }

        System.out.println("\nTwo positions containing the most water:");

        System.out.println("1st position = " + firstIndex
                + ", water = " + firstWater + " units");

        System.out.println("2nd position = " + secondIndex
                + ", water = " + secondWater + " units");

        sc.close();
    }
}
