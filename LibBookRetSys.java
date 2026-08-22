import java.util.Scanner;

public class LibBookRetSys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalBooks = 0;
        int totalFine = 0;

        String overdueBooks = "";
        String choice = "yes";

        while (choice.equals("yes")) {

            System.out.print("Enter Book ID: ");
            String bookId = sc.nextLine();

            System.out.print("Enter Due Week: ");
            int dueWeek = sc.nextInt();

            System.out.print("Enter Due Day (1-7): ");
            int dueDay = sc.nextInt();

            System.out.print("Enter Return Week: ");
            int returnWeek = sc.nextInt();

            System.out.print("Enter Return Day (1-7): ");
            int returnDay = sc.nextInt();

            sc.nextLine();

            totalBooks++;

            int dueTotalDays = (dueWeek - 1) * 7 + dueDay;
            int returnTotalDays = (returnWeek - 1) * 7 + returnDay;

            if (returnTotalDays > dueTotalDays) {

                int overdueDays = returnTotalDays - dueTotalDays;
                int fine = overdueDays * 5;

                totalFine = totalFine + fine;

                overdueBooks = overdueBooks + bookId + "\n";

                System.out.println("Book is overdue by "
                        + overdueDays + " day(s).");
                System.out.println("Fine: Rs. " + fine);

            } else if (returnTotalDays < dueTotalDays) {

                System.out.println(
                        "Thank you for returning the book before due!");

            } else {

                System.out.println(
                        "Book returned on time. Thank you!");
            }

            System.out.print(
                    "Want to process another book? (yes or no): ");
            choice = sc.nextLine();
        }

        System.out.println("\nLIBRARY RETURN SUMMARY");

        System.out.println(
                "Total books processed: " + totalBooks);

        System.out.println(
                "Total fine collected: Rs. " + totalFine);

        System.out.println("Overdue Book IDs:");

        if (overdueBooks.equals("")) {
            System.out.println("No overdue books.");
        } else {
            System.out.println(overdueBooks);
        }

        sc.close();
    }
}
