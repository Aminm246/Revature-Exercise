package week2.day2.assignment1;

import java.util.Scanner;

public class BillingApplication {

    // Returns the discount percentage for a given total amount
    public static int getDiscountPercent(double totalAmount) {
        if (totalAmount >= 5000) {
            return 10;
        } else if (totalAmount >= 1000) {
            return 5;
        } else {
            return 0;
        }
    }

    // Returns the discount amount in rupees (not the percentage)
    public static double calculateDiscount(double totalAmount) {
        int discountPercent = getDiscountPercent(totalAmount);
        return totalAmount * discountPercent / 100;
    }

    // Prints the formatted bill
    public static void printBill(String customerName, String productName, double price,
                                 int quantity, double totalAmount, int discountPercent,
                                 double discountAmount, double finalAmount) {
        System.out.println();
        System.out.println("========== CUSTOMER BILL - SMARTSTORE ==========");
        System.out.println("Customer         : " + customerName);
        System.out.println("Product          : " + productName);
        System.out.printf("Price            : Rs. %.2f%n", price);
        System.out.println("Quantity         : " + quantity);
        System.out.printf("Total            : Rs. %.2f%n", totalAmount);
        System.out.println("Discount         : " + discountPercent + "%");
        System.out.printf("Discount amount  : Rs. %.2f%n", discountAmount);
        System.out.println("-----------------------------------------------");
        System.out.printf("Final amount     : Rs. %.2f%n", finalAmount);
        System.out.println("===============================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter product price (Rs.): ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        double totalAmount = price * quantity;
        int discountPercent = getDiscountPercent(totalAmount);
        double discountAmount = calculateDiscount(totalAmount);
        double finalAmount = totalAmount - discountAmount;

        printBill(customerName, productName, price, quantity,
                  totalAmount, discountPercent, discountAmount, finalAmount);

        scanner.close();
    }
}