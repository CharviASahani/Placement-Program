import java.util.Scanner;

public class ArrayOpt {
    public static int calculateWater(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }

        int left = 0;
        int right = arr.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= leftMax) {
                    leftMax = arr[left]; 
                } else {
                    totalWater += leftMax - arr[left]; 
                }
                left++;
            } else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right]; 
                } else {
                    totalWater += rightMax - arr[right]; 
                }
                right--;
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of walls: ");
        int n = scanner.nextInt();

        if (n < 3) {
            System.out.println("Total water trapped: 0 units (At least 3 walls are required)");
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
