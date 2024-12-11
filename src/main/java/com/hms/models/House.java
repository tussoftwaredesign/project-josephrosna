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

public final class House extends Property {
    private boolean hasGarden;

    // Constructor
    public House(String address, double rentPrice, boolean isAvailable, boolean hasGarden) {
        super(address, rentPrice, isAvailable);  // Calls superclass constructor
        this.hasGarden = hasGarden;
    }

    // Getter for hasGarden
    public boolean hasGarden() {
        return hasGarden;
    }
}
