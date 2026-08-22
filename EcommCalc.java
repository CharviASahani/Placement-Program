import java.util.Scanner;

public class EcommCalc {

    //method overloading
    public static double calcShipping(double weight) {
        return 50 + (10 * weight);
    }

    public static double calcShipping(double weight, int distanceKm) {
        return 50 + (10 * weight) + (2 * distanceKm);
    }

    public static double calcShipping(double weight, int distanceKm, boolean isExpress) {
        double shipping = 50 + (10 * weight) + (2 * distanceKm);

        if (isExpress) {
            shipping = shipping + 100;
        }

        return shipping;
    }

    public static double calcCartTotal(double[] itemPrices) {
        double total = 0;

        for (double price : itemPrices) {
            total = total + price;
        }

        return total;
    }

    public static double applyCoupon(double total, String coupon) {
        if (coupon.equalsIgnoreCase("SAVE10")) {
            return total * 0.10;
        }
        else if (coupon.equalsIgnoreCase("SAVE20")) {
            return total * 0.20;
        }
        else {
            return 0;
        }
    }

    public static void generateInvoice(double cartTotal, double shipping, double couponDiscount) {

        double finalTotal = cartTotal + shipping - couponDiscount;

        System.out.println("INVOICE");
        System.out.println("Cart Total      : Rs. " + cartTotal);
        System.out.println("Shipping Charge : Rs. " + shipping);
        System.out.println("Coupon Discount : Rs. " + couponDiscount);
        System.out.println("Final Total     : Rs. " + finalTotal);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        double[] itemPrices = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter price of item " + (i + 1) + ": ");
            itemPrices[i] = sc.nextDouble();
        }

        System.out.print("Enter weight in kg: ");
        double weight = sc.nextDouble();

        System.out.print("Enter distance in km: ");
        int distanceKm = sc.nextInt();

        System.out.print("Is express delivery? (true/false): ");
        boolean isExpress = sc.nextBoolean();

        System.out.print("Enter coupon code (SAVE10/SAVE20/NONE): ");
        String coupon = sc.next();

        double cartTotal = calcCartTotal(itemPrices);

        double shipping = calcShipping(weight, distanceKm, isExpress);

        double couponDiscount = applyCoupon(cartTotal, coupon);

        generateInvoice(cartTotal, shipping, couponDiscount);

        sc.close();
    }
}

// shipping charge depends on bare minimum 5o Rs., weight of total items and distance between store and delivery location
// Total is (total cost) - (coupon discount, if any) + (shipping charge)