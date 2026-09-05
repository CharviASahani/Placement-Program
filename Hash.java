import java.util.*;

public class Hash {

    public static int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Put all array elements into HashSet
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {

            // Check if num is the starting number
            if (!set.contains(num - 1)) {

                int current = num;
                int currentLength = 1;

                // Find consecutive numbers
                while (set.contains(current + 1)) {
                    current++;
                    currentLength++;
                }

                longest = Math.max(longest, currentLength);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Longest consecutive sequence length: "
                + longestConsecutive(nums));

        sc.close();
    }
}
