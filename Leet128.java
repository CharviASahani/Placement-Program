import java.util.*;

public class Leet128 {

    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longest = 1;
        int currentLength = 1;

        for (int i = 1; i < nums.length; i++) {

            // Skip duplicate elements
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            // Check if consecutive
            if (nums[i] == nums[i - 1] + 1) {
                currentLength++;
            } else {
                currentLength = 1;
            }

            longest = Math.max(longest, currentLength);
        }

        return longest;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = longestConsecutive(nums);

        System.out.println("Length of longest consecutive sequence: " + result);

        sc.close();
    }
}
