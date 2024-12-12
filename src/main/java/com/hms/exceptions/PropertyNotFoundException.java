/**
 * House Rental Management System
 * Developer: Rosna Joseph
 * This system manages house rental listings and tenants using modern Java 21 features.
 * */
package com.hms.exceptions;
// PropertyNotFoundException.java (Checked exception) Feature 5.1
public class PropertyNotFoundException extends Exception {
    public PropertyNotFoundException(String message) {
        super(message);
    }
}
