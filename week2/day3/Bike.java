package com.vehiclerental;

// INHERITANCE: Bike extends (inherits from) Vehicle
public class Bike extends Vehicle {

    public Bike(String vehicleNumber, String model, double ratePerDay, int days) {
        super(vehicleNumber, model, ratePerDay, days); // call parent constructor
    }

    // POLYMORPHISM: overriding the parent method (10% discount)
    @Override
    public double calculateRent() {
        return super.calculateRent() * 0.90;
    }

    @Override
    public void displayDetails() {
        System.out.println("Bike | " + vehicleNumber + " | " + String.format("%-8s", model)
                + " | Days: " + days + " | Rent: " + calculateRent());
    }
}