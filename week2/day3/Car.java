package com.vehiclerental;

// INHERITANCE: Car extends (inherits from) Vehicle
public class Car extends Vehicle {
    private double insurancePerDay;

    public Car(String vehicleNumber, String model, double ratePerDay, int days, double insurancePerDay) {
        super(vehicleNumber, model, ratePerDay, days); // call parent constructor
        this.insurancePerDay = insurancePerDay;
    }

    // POLYMORPHISM: overriding the parent method
    @Override
    public double calculateRent() {
        return (ratePerDay + insurancePerDay) * days;
    }

    @Override
    public void displayDetails() {
        System.out.println("Car  | " + vehicleNumber + " | " + String.format("%-8s", model)
                + " | Days: " + days + " | Rent: " + calculateRent());
    }
}