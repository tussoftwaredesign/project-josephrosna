/**
 * House Rental Management System
 * Developer: Rosna Joseph
 * This system manages house rental listings and tenants using modern Java 21 features.
 */
package com.hms.models;

/**
 * Sealed class demonstrating sealed interfaces and inheritance.
 * It includes the property address, rent price, availability, and the landlordId for property ownership.
 **/

public sealed class Property implements PropertyInterface permits Apartment, House {
    private int id; // New field for property ID
    private String address;
    private double rentPrice;
    private boolean isAvailable;
    private final PropertyType propertyType;
    private int landlordId;


    public Property(int id, String address, double rentPrice, boolean isAvailable, PropertyType propertyType, int landlordId) {
        this.id = id;
        this.address = address;
        this.rentPrice = rentPrice;
        this.isAvailable = isAvailable;
        this.propertyType = propertyType;
        this.landlordId = landlordId;
    }
     // Copy constructor

     public Property(Property original) {

        this.id = original.id;
        this.address = original.address;
        this.rentPrice = original.rentPrice;
        this.isAvailable = original.isAvailable;
        this.propertyType = original.propertyType;
        this.landlordId = original.landlordId;

    }


    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public int getLandLordId() {
        return landlordId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public void setRentPrice(double rentPrice) {

        this.rentPrice = rentPrice;

    }
    @Override
    public PropertyType getType() {
        return propertyType;
    }

    @Override
    public String toString() {
        return "Property ID: " + id + ", Address: " + address + ", Rent Price: €" + rentPrice 
                + ", Available: " + (isAvailable ? "Yes" : "No") + ", Property Type: " + propertyType 
                + ", Landlord ID: " + landlordId;
    }
}
