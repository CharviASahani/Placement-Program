import java.util.Scanner;

public class CollegeElection {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of voter IDs: ");
        int n = sc.nextInt();

        int[] voterIds = new int[n];

        System.out.println("Enter voter IDs:");
        for (int i = 0; i < n; i++) {
            voterIds[i] = sc.nextInt();
        }

        System.out.println("\nArray with each ID only once:");

        for (int i = 0; i < n; i++) {

            boolean alreadyCounted = false;

            for (int j = 0; j < i; j++) {

                if (voterIds[i] == voterIds[j]) {
                    alreadyCounted = true;
                    break;
                }
            }

            if (!alreadyCounted) {
                System.out.print(voterIds[i] + " ");
            }
        }

        int duplicateCount = 0;

        System.out.println("\n\nDuplicate voter IDs:");

        for (int i = 0; i < n; i++) {

            boolean alreadyCounted = false;

            for (int j = 0; j < i; j++) {

                if (voterIds[i] == voterIds[j]) {
                    alreadyCounted = true;
                    break;
                }
            }

            if (!alreadyCounted) {

                int frequency = 0;

                // Find frequency of current ID
                for (int j = 0; j < n; j++) {

                    if (voterIds[i] == voterIds[j]) {
                        frequency++;
                    }
                }

                // Check if ID is duplicate
                if (frequency > 1) {

                    System.out.println(
                        "ID " + voterIds[i] + " - " + frequency + " times"
                    );

                    duplicateCount++;
                }
            }
        }

        // Print total duplicate IDs
        System.out.println("\nTotal number of duplicate IDs: "
                           + duplicateCount);

        sc.close();
    }
}
