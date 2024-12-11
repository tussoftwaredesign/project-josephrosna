package com.hms.exceptions;
// InvalidPaymentException.java (Unchecked exception) Feature 5.2
public class InvalidPaymentException extends RuntimeException {
    public InvalidPaymentException(String message) {
        super(message);
    }
}
