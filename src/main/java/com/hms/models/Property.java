/**
 * House Rental Management System
 * Developer: Rosna Joseph
 * This system manages house rental listings and tenants using modern Java 21 features.
 * */
package com.hms.models;

/**
 *  Sealed class demonstrating sealed interfaces and inheritance
 *  It includes the property address, rent price, and availability.
 **/

public sealed class Property permits Apartment, House {
    private String address;
    private double rentPrice;
    private boolean isAvailable;

    // Constructor
    public Property(String address, double rentPrice, boolean isAvailable) {
        this.address = address;
        this.rentPrice = rentPrice;
        this.isAvailable = isAvailable;
    }

    // Getters
    public String getAddress() {
        return address;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "Address: " + address + ", Rent: " + rentPrice + ", Available: " + isAvailable;
    }
}

