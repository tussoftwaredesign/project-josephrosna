
/**
 * House Rental Management System
 * Developer: Rosna Joseph
 * This system manages house rental listings and tenants using modern Java 21 features.
 * Main class to demonstrate the application functionality.
 * It allows users to interact with the system via terminal commands.
 */
package com.hms;

import java.time.LocalDate; // Java Date-Time API -- Feature 8.4
import java.util.LinkedHashMap;
import java.util.List; // Java List interface -- Feature 8.3
import java.util.Map;

import com.hms.exceptions.LandlordNotFoundException;
import com.hms.exceptions.PropertyNotFoundException;
import com.hms.models.ImmutableProperty;
import com.hms.models.Landlord;
import com.hms.models.Property;
import com.hms.models.PropertyInterface;
import com.hms.models.RentalAgreement;
import com.hms.models.Tenant;
import com.hms.services.RentalService;
import com.hms.services.YearlyRentCalculatorService;
import com.hms.utils.Utility;

public class Main {
    private static RentalService rentalService = new RentalService();
    private static YearlyRentCalculatorService yearlyRentCalculatorService = new YearlyRentCalculatorService();

    public static void main(String[] args) {
       

        
        System.out.println("Welcome to the House Rental Management System");
        System.out.println("Browse through the available properties and rent your dream home today!");

        // Initialize few users and properties to demonstrate the system
        rentalService.initializeUsers();
        rentalService.initializeProperties();

        // Display basic details of available rental properties
        displayAvailableProperties();

        // Prompt user to enter a property ID to display more details
        int propertyId = Utility.readInt("Enter the property ID to display more details: ");
        rentalService.displayPropertyDetails(propertyId);

        // Main menu
        while (true) {
            int choice = Utility.displayMenu("Login as:", "Tenant", "Landlord","Rent Calculator", "Exit");

            switch (choice) {
                case 1:
                    handleTenantMenu();
                    break;
                case 2:
                    handleLandlordMenu();
                    break;
                case 3:
                     handleLatestJavaFeatures();
                     break;
                case 4:
                    System.out.println("Thank you for using the House Rental Management System Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void handleTenantMenu() {
        String name = Utility.readString("Enter Tenant Name: ");
        Tenant tenant = rentalService.getTenantByName(name);
        if (tenant == null) {
            System.out.println("Tenant not found! Creating new tenant.");
            tenant = rentalService.createTenant(name);
        }
        // Tenant menu
        while (true) {
            int choice = Utility.displayMenu("Tenant Menu:", "View Available Properties", "Rent a Property",
                    "Make a Payment", "View My Rental Agreement", "Show & Update Name", "Search By Price",
                    "Modify Property", "Logout");

            switch (choice) {
                case 1:
                    displayAvailableProperties();
                    break;
                case 2:
                    rentProperty(tenant);
                    break;
                case 3:
                    makePayment(tenant);
                    break;
                case 4:
                    viewRentalAgreement(tenant);
                    break;
                case 5:
                    getTenantDetails(tenant);
                    break;
                case 6:
                    checkAffordableProperties();
                    break;
                case 7:
                    modifyPropertyByTenant();
                    break;
                case 8:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void handleLandlordMenu() {
        String name = Utility.readString("Enter Landlord Name: ");
        Landlord landlord = rentalService.getLandlordByName(name);
        if (landlord == null) {
            System.out.println("Landlord not found! Creating new landlord.");
            landlord = rentalService.createLandlord(name);
        }

        // Landlord menu loop
        while (true) {
            int choice = Utility.displayMenu("Landlord Menu:", "Add a Property", "View All Properties",
                    "View Rental Agreements", "Copy A Property", "Logout");

            switch (choice) {
                case 1:
                    rentalService.addProperty(landlord);
                    break;
                case 2:
                    rentalService.displayProperties();
                    break;
                case 3:
                    rentalService.getRentalAgreementsForLandlord(landlord);
                    break;
                case 4:
                    copyProperty(landlord);
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    private static void handleLatestJavaFeatures()
    {
       
        System.out.println("Explore the latest Java features in this section.");

        while (true) {
            int choice = Utility.displayMenu("Choose a feature to explore:", "Yearly Rent Calculator",
                    "Yearly Rent Calculator for Properties", "Yearly Rent Calculator for Tenant", "Exit");
            switch (choice) {
                case 1:
                    calculateYearlyRent();
                    break;
                case 2:
                    calculateYearlyRentForProperties();
                    break;
                case 3:
                    calculateYearlyRentForTenant();
                    break;
                case 4:
                    System.out.println("Exiting Latest Java Features Section...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
    // Feature 9 - Defensive Copying
    private static void copyProperty(Landlord landlord) {
        try {
            rentalService.displayProperties();
            int propertyId = Utility.readInt("Enter the property ID to copy: ");
            Property originalProperty = (Property) rentalService.findPropertyById(propertyId);
            Property propertyCopy = new Property(originalProperty);
            System.out.println("Original property details:");
            rentalService.displayPropertyDetails(propertyId);
            System.out.println("Copy property details:");
            rentalService.CopyProperty(landlord, propertyCopy);
            System.out.println("Property ID: " + propertyCopy.getId() + ", Address: " + propertyCopy.getAddress()
                    + ", Rent Price: " + propertyCopy.getRentPrice() + ", Available: " + propertyCopy.isAvailable());
        } catch (PropertyNotFoundException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    // Feature 8.2 - String Builder
    private static void displayAvailableProperties() {
        System.out.println("\nAvailable Properties:");
        StringBuilder sb = new StringBuilder();
        rentalService.searchProperties(property -> property.isAvailable()).forEach(property -> {
            sb.append("Property ID: ").append(((Property) property).getId())
                    .append(", Address: ").append(property.getAddress())
                    .append("\n");
        });
        System.out.println(sb.toString());
    }

    // Feature 8.4 Date-Time API
    private static void rentProperty(Tenant tenant) {
        int propertyId = Utility.readInt("Enter the ID of the property to rent: ");
        try {
            Property property = (Property) rentalService.findPropertyById(propertyId);
            if (!property.isAvailable()) {
                System.out.println("Property is not available!");
                return;
            }

            property.setAvailable(false);

            LocalDate startDate = LocalDate.now();
            LocalDate endDate = startDate.plusMonths(12);
            double rentAmount = property.getRentPrice();
            int landlordId = property.getLandLordId();

            try {
                Landlord landlord = rentalService.findLandlordById(landlordId);
                // Feature 11 - Record
                RentalAgreement rentalAgreement = new RentalAgreement(tenant, property, startDate, endDate, rentAmount,
                        landlord);
                rentalService.addRentalAgreement(rentalAgreement);
                System.out.println("\nRental Agreement Created:");
                System.out.println(rentalAgreement);
                System.out.println("Property rented successfully!");
            } catch (LandlordNotFoundException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        } catch (PropertyNotFoundException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    private static void makePayment(Tenant tenant) {
        double amount = Utility.readDouble("Enter the amount to pay: ");
        if (Utility.validateInput(amount, val -> val > 0, "Payment amount must be greater than zero.")) {
            System.out.println("Payment of EUR:  " + amount + " made successfully!");
        }
    }

    private static void viewRentalAgreement(Tenant tenant) {
        List<RentalAgreement> agreements = rentalService.getRentalAgreementsForTenant(tenant);
        if (agreements.isEmpty()) {
            System.out.println("No rental agreements found for tenant.");
        } else {
            agreements.forEach(System.out::println);
        }
    }

    private static void getTenantDetails(Tenant tenant) {
        System.out.println("Before name change");
        tenant.displayDetails();
        String newName = Utility.readString("Enter the new name: ");
        tenant.setName(newName);
        tenant.setEmail(newName + "@hrms.com");
        System.out.println("After name change");
        tenant.displayDetails();
    }

    // Feature 13 - Lambda Expressions
    // Featuere 13.1 - Final and Effectively Final Variables
    // Feature 13.2 - Method References
    private static void checkAffordableProperties() {
        final double maxRent = Utility.readDouble("Enter the maximum affordable rent: ");
        double minRent = Utility.readDouble("Enter the minimum rent to filter properties: ");
        List<PropertyInterface> affordableProperties = rentalService.searchProperties(
                property -> PropertyInterface.isAffordable(property, maxRent));

        if (affordableProperties.isEmpty()) {
            System.out.println("No affordable properties found.");
            return;
        }
        System.out.println("\nProperties with rent greater than or equal to " + minRent + " and less than or equal to "
                + maxRent + ":");
        affordableProperties.stream()
                .filter(property -> property.getRentPrice() <= maxRent && property.getRentPrice() >= minRent)
                .map(PropertyInterface::toString) // Method reference
                .forEach(System.out::println);
    }

    public static void modifyPropertyByTenant() {
        try {
            int propertyId = Utility.readInt("Enter the property ID to modify ");
            // Create an immutable property
            ImmutableProperty immutableProperty = rentalService.createImmutableProperty(propertyId);
            // Display the immutable property details
            System.out.println("Immutable Property details:");
            System.out.println(immutableProperty);
            System.out.println("\nNote: This property is immutable and cannot be modified after creation.");
        } catch (PropertyNotFoundException ex) {
            System.err.println(
                    "Error: The requested property does not exist. Immutable properties cannot be created from non-existent data.");
        } catch (UnsupportedOperationException ex) {
            // Handle any attempt to modify immutability
            System.err.println("Error: The property is immutable and cannot be changed.");
        }
    }

    private static void calculateYearlyRent() {
        double monthlyRent = Utility.readDouble("Enter the monthly rent: ");
        double yearlyRent = yearlyRentCalculatorService.calculateYearlyRent(monthlyRent);
        System.out.println("Yearly Rent:  EUR:  " + yearlyRent);
    }
    private static void calculateYearlyRentForProperties() {
        int propertyCount = Utility.readInt("Enter the number of properties: ");
        Map<String, Double> properties = new LinkedHashMap<>();
        for (int i = 0; i < propertyCount; i++) {
            String propertyName = Utility.readString("Enter property name: ");
            double propertyMonthlyRent = Utility.readDouble("Enter monthly rent for " + propertyName + ": ");
            properties.put(propertyName, propertyMonthlyRent);
        }
        try {
            Map<String, Double> yearlyRents = yearlyRentCalculatorService.calculateYearlyRentForProperties(properties);
            yearlyRents.forEach((property, rent) -> {
                System.out.println(property + " - Yearly Rent:  EUR:  " + rent);
            });
        } catch (Exception ex) {
            System.err.println("An error occurred: " + ex.getMessage());
        }
    }
    private static void calculateYearlyRentForTenant() {
        String tenantName = Utility.readString("Enter tenant name: ");
        double tenantMonthlyRent = Utility.readDouble("Enter monthly rent for tenant's property: ");
        double tenantYearlyRent = yearlyRentCalculatorService.calculateYearlyRentForTenant(tenantName, tenantMonthlyRent);
        System.out.println("Yearly Rent for tenant " + tenantName + ": EUR:  " + tenantYearlyRent);
    }

    

}