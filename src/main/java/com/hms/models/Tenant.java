/**
 * House Rental Management System
 * Developer: Rosna Joseph
 * This system manages house rental listings and tenants using modern Java 21 features.
 * */

 /**
  * Class to represent a tenant in the system
  */

package com.hms.models;

public class Tenant extends Person {
    private String email;

    public Tenant(String name, String email, Integer id) {
        super(name, id);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Email: " + email);
    }
}
