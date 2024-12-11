/**
 * House Rental Management System
 * Developer: Rosna Joseph
 * This system manages house rental listings and tenants using modern Java 21 features.
 * */
package com.hms.models;

/**
 * Subclass to demonstrate inheritance, super() usage, and overriding
 * It stores landlord-specific information such as name, contact info, and owned properties.
 */
public class Landlord extends Person {
    private double balance;

    // Constructor demonstrating super() to call the parent constructor (Feature 4.2)
    public Landlord(String name, double balance) {
        super(name);  // Calls the constructor of the superclass (Person)
        this.balance = balance;
    }

    // Overriding displayDetails to demonstrate polymorphism (Feature 4.1)
    @Override
    public void displayDetails() {
        super.displayDetails();  // Calls the method from the superclass (Feature 4.2)
        System.out.println("Balance: " + balance);
    }
}
