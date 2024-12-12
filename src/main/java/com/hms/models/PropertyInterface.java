/**
 * House Rental Management System
 * Developer: Rosna Joseph
 * This system manages house rental listings and tenants using modern Java 21 features.
 * */

 /**
  * Interface to demonstrate default and private methods
    * It includes the property address, rent price, and availability.
  */
package com.hms.models;

public interface PropertyInterface {
    String getAddress();
    double getRentPrice();
    boolean isAvailable();
    void setAvailable(boolean available);
    PropertyType getType();

    // Static method for shared logic
    static boolean isAffordable(PropertyInterface property, double maxRent) {
        return property.getRentPrice() <= maxRent;
    }

    // Default method with a common implementation
    default void displayInfo() {
        System.out.println("Address: " + getAddress() + ", Rent: " + getRentPrice());
    }

    // Private method for internal use
    private void log(String message) {
        System.out.println("Log: " + message);
    }

    // Default method using private method
    default void updateRentPrice(double newPrice) {
        log("Updating rent price to " + newPrice);
        setRentPrice(newPrice);
    }

    // Method to set rent price to be used by default method
    void setRentPrice(double rentPrice);
}