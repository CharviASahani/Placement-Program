import java.util.Scanner;

public class WeatherReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        double[] temp = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter temperature for Day  " + (i + 1) + ": ");
            temp[i] = sc.nextDouble();
        }

        double hottest = temp[0];
        double coldest = temp[0];
        int hottestDay = 1;
        int coldestDay = 1;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            sum += temp[i];

            // Find hottest temperature and its day
            if (temp[i] > hottest) {
                hottest = temp[i];
                hottestDay = i + 1;
            }

            // Find coldest temperature and its day
            if (temp[i] < coldest) {
                coldest = temp[i];
                coldestDay = i + 1;
            }
        }

        // Calculate average
        double average = sum / n;

        // Count days hotter than average
        int hotterThanAverage = 0;

        for (int i = 0; i < n; i++) {
            if (temp[i] > average) {
                hotterThanAverage++;
            }
        }

        // Temperature range
        double range = hottest - coldest;

        // Generate report
        System.out.println("\n===== WEATHER REPORT =====");
        System.out.printf("Average Temperature: %.2f°C%n", average);
        System.out.printf("Hottest Day: Day %d (%.2f°C)%n", hottestDay, hottest);
        System.out.printf("Coldest Day: Day %d (%.2f°C)%n", coldestDay, coldest);
        System.out.printf("Temperature Range: %.2f°C%n", range);
        System.out.println("Days hotter than average: " + hotterThanAverage);

        sc.close();
    }
}
