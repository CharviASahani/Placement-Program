import java.util.ArrayList;
import java.util.Scanner;

public class LibraryRet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalBooks = 0;
        int totalFine = 0;
        ArrayList<String> overdueBooks = new ArrayList<>();

        String choice = "yes";

        while (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter Book ID: ");
            String bookId = sc.nextLine();

            System.out.print("Enter Due Date (day number 1-7): ");
            int dueDate = sc.nextInt();

            System.out.print("Enter Return Date (day number 1-7): ");
            int returnDate = sc.nextInt();
            sc.nextLine();

            totalBooks++;

            if (returnDate > dueDate) {
                int overdueDays = returnDate - dueDate;
                int fine = overdueDays * 5;

                totalFine += fine;
                overdueBooks.add(bookId);

                System.out.println("Book is overdue by " + overdueDays + " day(s).");
                System.out.println("Fine: Rs. " + fine);
            } else if (returnDate < dueDate) {
                System.out.println("Thank you for returning the book before due!");
            } else {
                System.out.println("Book returned on time. Thank you!");
            }

            System.out.print("Want to process another book? (yes or no): ");
            choice = sc.nextLine();
        }

        System.out.println("LIBRARY RETURN SUMMARY ");
        System.out.println("Total books processed: " + totalBooks);
        System.out.println("Total fine collected: Rs. " + totalFine);

        System.out.println("Overdue Book IDs:");
        if (overdueBooks.isEmpty()) {
            System.out.println("No overdue books.");
        } else {
            for (String id : overdueBooks) {
                System.out.println(id);
            }
        }

        sc.close();
    }
}
