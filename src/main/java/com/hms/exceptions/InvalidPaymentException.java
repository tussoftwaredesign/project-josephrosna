/**
 * House Rental Management System
 * Developer: Rosna Joseph
 * This system manages house rental listings and tenants using modern Java 21 features.
 * */
package com.hms.exceptions;
// InvalidPaymentException.java (Unchecked exception) Feature 5.2
public class InvalidPaymentException extends RuntimeException {
    public InvalidPaymentException(String message) {
        super(message);
    }
}
