package com.vehiclerental;

import java.util.Scanner;

public class RentalApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vehicles: ");
        int count = Integer.parseInt(sc.nextLine().trim());

        // One array holds both Car and Bike objects (parent-type array)
        Vehicle[] vehicles = new Vehicle[count];

        for (int i = 0; i < count; i++) {
            String type;
            // Keep asking until the type is valid (1 or 2)
            while (true) {
                System.out.print("Enter type (1-Car, 2-Bike): ");
                type = sc.nextLine().trim();
                if (type.equals("1") || type.equals("2")) {
                    break;
                }
                System.out.println("Invalid type! Please enter 1 or 2.");
            }

            System.out.print("Enter Vehicle Number: ");
            String number = sc.nextLine();
            System.out.print("Enter Model: ");
            String model = sc.nextLine();
            System.out.print("Enter Rate per Day: ");
            double rate = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Enter Days: ");
            int days = Integer.parseInt(sc.nextLine().trim());

            // POLYMORPHISM: parent-type reference holds child objects
            Vehicle v;
            if (type.equals("1")) {
                System.out.print("Enter Insurance per Day: ");
                double insurance = Double.parseDouble(sc.nextLine().trim());
                v = new Car(number, model, rate, days, insurance);
            } else {
                v = new Bike(number, model, rate, days);
            }
            vehicles[i] = v;
        }

        System.out.println("\n--- Rental Details ---");
        double total = 0;
        for (Vehicle v : vehicles) {
            v.displayDetails();         // runtime polymorphism: Car/Bike version runs
            total += v.calculateRent(); // runtime polymorphism
        }
        System.out.println("Total Rent Collected: " + total);

        sc.close();
    }
}