/**
 * House Rental Management System
 * Developer: Rosna Joseph
 * This system manages house rental listings and tenants using modern Java 21 features.
 * */

// Exception class for Landlord not found
package com.hms.exceptions;

public class LandlordNotFoundException extends Exception {
    public LandlordNotFoundException(String message) {
        super(message);
    }
}
