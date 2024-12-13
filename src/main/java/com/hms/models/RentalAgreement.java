/**
 * House Rental Management System
 * Developer: Rosna Joseph
 * This system manages house rental listings and tenants using modern Java 21 features.
 * */

/**
 * Record class to represent a rental agreement between a tenant and a landlord
 */

package com.hms.models;
import java.time.LocalDate;

public record RentalAgreement(Tenant tenant, Property property, LocalDate startDate, LocalDate endDate, double rentAmount, Landlord landlord) {

    public RentalAgreement(Tenant tenant, Property property, LocalDate startDate, LocalDate endDate, double rentAmount,
            Landlord landlord) {
        this.tenant = tenant;
        this.property = property;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentAmount = rentAmount;
        this.landlord = landlord;
    }

    @Override
    public String toString() {
        return "Rental Agreement: \n" +
                "Tenant: " + tenant.getName() + "\n" +
                "Landlord: " + landlord.getName() + "\n" +
                "Property: " + property.getAddress() + "\n" +
                "Rent Amount: EUR:  " + rentAmount + "\n" +
                "Start Date: " + startDate + "\n" +
                "End Date: " + endDate;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public Property getProperty() {
        return property;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getRentAmount() {
        return rentAmount;
    }
}
