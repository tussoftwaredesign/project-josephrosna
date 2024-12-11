/**
 * House Rental Management System
 * Developer: Rosna Joseph
 * This system manages house rental listings and tenants using modern Java 21 features.
 * */
package com.hms.models;

/**
 * Tenant sub class represents a tenant in the rental system.
 * It stores tenant-specific information such as name, contact info, and applied properties.
 * Subclass to demonstrate  'this()', 'this', and encapsulation
 **/

 public class Tenant {
    private String name;
    private String email;

    // Constructor demonstrating this() to call another constructor (Feature 1.1)
    public Tenant() {
        this("Rosna Joseph", "rosna@example.com");  // Calls the parameterized constructor
    }

    // Constructor with parameters demonstrating 'this' for field reference (Feature 1.1)
    public Tenant(String name, String email) {
        this.name = name;  // 'this' distinguishes the field from the parameter
        this.email = email;
    }

    // Getters and setters (Encapsulation - Feature 2)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;  // 'this' used to refer to the current instance
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;  // 'this' used to refer to the current instance
    }
}

