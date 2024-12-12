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

    public Apartment(int id, String address, double rentPrice, boolean isAvailable, PropertyType propertyType,
            int floorNumber,int landlordId) {
        super(id,address, rentPrice, isAvailable, propertyType,landlordId); // Calls superclass constructor
        this.floorNumber = floorNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    @Override
    public String toString() {
        return super.toString() + ", Floor Number: " + floorNumber;
    }
}
