/**
 * House Rental Management System
 * Developer: Rosna Joseph
 * This system manages house rental listings and tenants using modern Java 21 features.
 * */

 package com.hms.models;

 /**
  * Superclass to demonstrate inheritance, encapsulation, and polymorphism
  * Demonstrates encapsulation by using private fields with public getters and setters (Feature 2)
  **/
public class Person {
    private String name;
    private Integer id;

    // Constructor to initialize the name and id fields
    public Person(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    // Getter for name (Encapsulation - Feature 2)
    public String getName() {
        return name;
    }
    public Integer getId() {
        return id;
    }

    // Setter for name (Encapsulation - Feature 2)
    public void setName(String name) {
        this.name = name;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    // Method to display details (Polymorphism - Feature 4.1)
    public void displayDetails() {
        System.out.println("Name: " + name);
    }
}
