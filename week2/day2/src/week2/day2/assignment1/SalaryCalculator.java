package week2.day2.assignment1;

import java.util.Scanner;

public class SalaryCalculator {

    // HRA is 20% of basic salary
    public static double calculateHra(double basic) {
        return basic * 0.20;
    }

    // DA is 10% of basic salary
    public static double calculateDa(double basic) {
        return basic * 0.10;
    }

    // Gross salary = basic + HRA + DA
    public static double calculateGross(double basic) {
        return basic + calculateHra(basic) + calculateDa(basic);
    }

    // Professional tax of Rs. 200 only if gross is ABOVE Rs. 20,000 (> not >=)
    public static double calculateProfessionalTax(double gross) {
        if (gross > 20000) {
            return 200;
        }
        return 0;
    }

    public static void printSalarySlip(int empId, String name, double basic, double hra,
                                       double da, double gross, double tax, double net) {
        System.out.println();
        System.out.println("========== EMPLOYEE SALARY SLIP ==========");
        System.out.println("Employee ID      : " + empId);
        System.out.println("Name             : " + name);
        System.out.printf("Basic salary     : Rs. %.2f%n", basic);
        System.out.printf("HRA (20%%)        : Rs. %.2f%n", hra);
        System.out.printf("DA (10%%)         : Rs. %.2f%n", da);
        System.out.printf("Gross salary     : Rs. %.2f%n", gross);
        System.out.printf("Professional tax : Rs. %.2f%n", tax);
        System.out.println("------------------------------------------");
        System.out.printf("Net salary       : Rs. %.2f%n", net);
        System.out.println("==========================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee ID: ");
        int empId = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter basic salary (Rs.): ");
        double basic = Double.parseDouble(scanner.nextLine());

        double hra = calculateHra(basic);
        double da = calculateDa(basic);
        double gross = calculateGross(basic);
        double tax = calculateProfessionalTax(gross);
        double net = gross - tax;

        printSalarySlip(empId, name, basic, hra, da, gross, tax, net);
        scanner.close();
    }
}