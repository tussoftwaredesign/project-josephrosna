package com.hms.models;
// Person.java (Superclass to demonstrate inheritance, encapsulation, and polymorphism)

// Demonstrates encapsulation by using private fields with public getters and setters (Item 2)
public class Person {
    private String name;

    // Constructor to initialize the name field
    public Person(String name) {
        this.name = name;
    }

    // Getter for name (Encapsulation - Item 2)
    public String getName() {
        return name;
    }

    // Setter for name (Encapsulation - Item 2)
    public void setName(String name) {
        this.name = name;
    }

    // Method to display details (Polymorphism - Item 4.1)
    public void displayDetails() {
        System.out.println("Name: " + name);
    }
}
