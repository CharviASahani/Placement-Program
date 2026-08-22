import java.util.Scanner;

public class PayrollManagementSystem {

    static double calBasicSal(String type, int hoursWorked) {
        double rate;

        if (type.equalsIgnoreCase("full time")) {
            rate = 500;
        } else if (type.equalsIgnoreCase("part time")) {
            rate = 250;
        } else if (type.equalsIgnoreCase("contract")) {
            rate = 350;
        } else {
            System.out.println("Invalid employee type.");
            return 0;
        }

        return rate * hoursWorked;
    }

    static double calBasicSal(int hoursWorked) {
        return 300 * hoursWorked;
    }

    static double calcHRA(double basic) {
        return 0.20 * basic;
    }

    static double calcDA(double basic) {
        return 0.15 * basic;
    }

    static double calcPF(double basic) {
        return 0.12 * basic;
    }

    static double calcTax(double gross) {
        if (gross < 50000) {
            return 0;
        } else if (gross <= 100000) {
            return 0.10 * gross;
        } else {
            return 0.20 * gross;
        }
    }

    static double calcNetSal(double gross, double tax, double pf) {
        return gross - tax - pf;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter employee type (Full Time / Part Time / Contract): ");
        String type = sc.nextLine();

        System.out.println("Enter hours worked: ");
        int hoursWorked = sc.nextInt();

        double basic = calBasicSal(type, hoursWorked);
        double hra = calcHRA(basic);
        double da = calcDA(basic);
        double pf = calcPF(basic);
        double gross = basic + hra + da;
        double tax = calcTax(gross);
        double netSalary = calcNetSal(gross, tax, pf);

        System.out.println("SALARY SLIP");
        System.out.println("Employee Type : " + type);
        System.out.println("Hours Worked  : " + hoursWorked);
        System.out.println("Basic Salary  : Rs. " + basic);
        System.out.println("HRA (20%)     : Rs. " + hra);
        System.out.println("DA (15%)      : Rs. " + da);
        System.out.println("Gross Salary  : Rs. " + gross);
        System.out.println("PF (12%)      : Rs. " + pf);
        System.out.println("Tax           : Rs. " + tax);
        System.out.println("Net Salary    : Rs. " + netSalary);

        sc.close();
    }
}
