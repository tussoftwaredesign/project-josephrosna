/**
 * House Rental Management System
 * Developer: Rosna Joseph
 * This system manages house rental listings and tenants using modern Java 21 features.
 * */
package com.hms.models;

public class Landlord extends Person {
    private Integer totalProperties;

    public Landlord(String name, Integer totalProperties, Integer id) {
        super(name, id);
        this.totalProperties = totalProperties;
    }

    public Integer getTotalProperties() {
        return totalProperties;
    }

    public void setTotalProperties(Integer totalProperties) {
        this.totalProperties = totalProperties;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Total Properties: " + totalProperties);
    }
}
