import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the principal amount:");
        double principal = sc.nextDouble();

        System.out.println("Enter the rate of interest:");
        double rate = sc.nextDouble();

        System.out.println("Enter the number of years:");
        int years = sc.nextInt();

        double openingBalance = principal;
        double totalInterest = 0;

        for (int year = 1; year <= years; year++) {

            double interest = openingBalance * rate / 100;
            double closingBalance = openingBalance + interest;

            System.out.println("Year: " + year);
            System.out.println("Opening Balance: " + openingBalance);
            System.out.println("Interest Earned: " + interest);
            System.out.println("Closing Balance: " + closingBalance);
            System.out.println();

            totalInterest += interest;
            openingBalance = closingBalance;
        }

        System.out.println("Total Interest Earned: " + totalInterest);
        System.out.println("Total Maturity Amount: " + openingBalance);

        sc.close();
    }
}
