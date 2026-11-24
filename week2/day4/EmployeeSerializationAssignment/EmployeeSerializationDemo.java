package com.employeemanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EmployeeSerializationDemo {

    public static void main(String[] args) {

        // 3. Create and initialize an array of 5 Employee objects
        Employee[] employees = new Employee[5];
        employees[0] = new Employee(101, "Aarav Sharma", "IT", 55000.00);
        employees[1] = new Employee(102, "Priya Patel", "HR", 48000.00);
        employees[2] = new Employee(103, "Rohan Mehta", "Finance", 62000.00);
        employees[3] = new Employee(104, "Sneha Iyer", "Marketing", 51000.00);
        employees[4] = new Employee(105, "Vikram Singh", "Operations", 58000.00);

        // 4. Write the Employee array to employees.dat
        try (FileOutputStream fos = new FileOutputStream("employees.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(employees);
            System.out.println("Employee array has been written to employees.dat successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 5. Read the Employee array from employees.dat
        try (FileInputStream fis = new FileInputStream("employees.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Employee[] retrievedEmployees = (Employee[]) ois.readObject();

            System.out.println("\nEmployee details read from file:");
            System.out.println("--------------------------------");
            for (Employee emp : retrievedEmployees) {
                System.out.println(emp);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}