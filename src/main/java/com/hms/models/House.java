/**
 * House Rental Management System
 * Developer: Rosna Joseph
 * This system manages house rental listings and tenants using modern Java 21 features.
 * */

package com.hms.models;

/**
 * Final class to demonstrate sealed class implementation
 * It includes the property address, rent price, and availability.
 **/

public final class House extends Property {
    private boolean hasGarden;

    public House(int id, String address, double rentPrice, boolean isAvailable, PropertyType propertyType, boolean hasGarden,int landlordId) {
        super(id,address, rentPrice, isAvailable, propertyType,landlordId); // Calls superclass constructor
        this.hasGarden = hasGarden;
    }
    public boolean hasGarden() {
        return hasGarden;
    }

    @Override
    public String toString() {
        return super.toString() + ", Has Garden: " + hasGarden;
    }

}
