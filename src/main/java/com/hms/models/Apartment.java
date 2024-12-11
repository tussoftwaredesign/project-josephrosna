/**
 * House Rental Management System
 * Developer: Rosna Joseph
 * This system manages house rental listings and tenants using modern Java 21 features.
 * */
package com.hms.models;

/**
 *  Final class to demonstrate sealed class implementation
 *  It includes the property address, rent price, and availability.
 **/


public final class Apartment extends Property {
    private int floorNumber;

    // Constructor
    public Apartment(String address, double rentPrice, boolean isAvailable, int floorNumber) {
        super(address, rentPrice, isAvailable);  // Calls superclass constructor
        this.floorNumber = floorNumber;
    }

    // Getter for floor number
    public int getFloorNumber() {
        return floorNumber;
    }
}
