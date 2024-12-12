/**
 * House Rental Management System
 * Developer: Rosna Joseph
 * This system manages house rental listings and tenants using modern Java 21 features.
 * */

/**
 * Service class to manage rental properties, tenants, landlords, and rental agreements
 */

package com.hms.services;

import com.hms.models.*;
import com.hms.exceptions.*;
import com.hms.utils.Utility;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RentalService {
    private List<Property> properties;
    private List<RentalAgreement> rentalAgreements;
    private Map<Integer, Tenant> tenants; // Map to store tenants by ID
    private Map<Integer, Landlord> landlords; // Map to store landlords by ID
    private int tenantIdCounter = 1; // Counter for generating new tenant IDs
    private int landlordIdCounter = 1; // Counter for generating new landlord IDs
    private static final Random random = new Random();

    public RentalService() {
        properties = new ArrayList<>();
        rentalAgreements = new ArrayList<>();
        tenants = new HashMap<>();
        landlords = new HashMap<>();
    }

    public Tenant createTenant(String name) {
        Tenant tenant = new Tenant(name, name + "@hrms.com", tenantIdCounter++);
        tenants.put(tenant.getId(), tenant);
        return tenant;
    }

    public Landlord createLandlord(String name) {
        Landlord landlord = new Landlord(name, 0, landlordIdCounter++);
        landlords.put(landlord.getId(), landlord);
        return landlord;
    }

    // Method to initialize users using arrays
    public void initializeUsers() {
        Tenant[] tenantArray = {
                new Tenant("ABC", "Alice@abc", tenantIdCounter++),
                new Tenant("DEF", "Bob@def", tenantIdCounter++),
                new Tenant("GHI", "Charlie@ghi", tenantIdCounter++)
        };

        Landlord[] landlordArray = {
                new Landlord("XYZ", 3, landlordIdCounter++),
                new Landlord("PQR", 2, landlordIdCounter++),
                new Landlord("LMN", 1, landlordIdCounter++)
        };

        for (Tenant tenant : tenantArray) {
            tenants.put(tenant.getId(), tenant);
        }

        for (Landlord landlord : landlordArray) {
            landlords.put(landlord.getId(), landlord);
        }
    }
    Property[] propertyArray = {
        new Property(1, "68 The Green Galway Ireland", 2000, true, PropertyType.HOUSE, 1),
        new Property(2, "60 The Green Galway Ireland", 1500, true, PropertyType.APARTMENT, 2),

    };
    // Method to initialize properties using an array
    public void initializeProperties() {
        properties.addAll(Arrays.asList(propertyArray));
    }
    // Adds a property to the list
    public void addProperty(Landlord landlord) {
        String address = Utility.readString("Enter Property Address: ");
        double rentPrice = Utility.readDouble("Enter Rent Price: ");
        boolean isApartment = Utility.readString("Is the property an Apartment? (yes/no): ")
                .equalsIgnoreCase("yes");
        Property property;
        int id = 10 + random.nextInt(90);
        if (isApartment) {
            int bedrooms = (int) Utility.readDouble("Enter the number of bedrooms: ");
            property = new Apartment(id, address, rentPrice, true, PropertyType.APARTMENT, bedrooms, landlord.getId());
        } else {
            boolean hasGarden = Utility.readString("Does the property have a garden? (yes/no): ")
                    .equalsIgnoreCase("yes");
            property = new House(id, address, rentPrice, true, PropertyType.HOUSE, hasGarden, landlord.getId());
        }
        properties.add(property);
        System.out.println("Property added successfully!");
    }
    public void CopyProperty(Landlord landlord,Property copyProperty) {
        int id = 10 + random.nextInt(90);
        Property property;
        if(copyProperty.getType() == PropertyType.APARTMENT)
        {
            property = new Apartment(id, copyProperty.getAddress(), copyProperty.getRentPrice(), true, PropertyType.APARTMENT,0, landlord.getId());
        }
        else
        {
            property = new House(id, copyProperty.getAddress(), copyProperty.getRentPrice(), true, PropertyType.HOUSE, false, landlord.getId());
        }
        properties.add(property);
        System.out.println("Property added successfully!");
    }

    // Displays all properties
    public void displayProperties() {
        if (properties.isEmpty()) {
            System.out.println("No properties available.");
            return;
        }

        properties.forEach(System.out::println);
    }

    public void addRentalAgreement(RentalAgreement agreement) {
        rentalAgreements.add(agreement);
    }

    public List<RentalAgreement> getRentalAgreementsForTenant(Tenant tenant) {
        List<RentalAgreement> tenantAgreements = new ArrayList<>();
        for (RentalAgreement agreement : rentalAgreements) {
            if (agreement.getTenant().equals(tenant)) {
                tenantAgreements.add(agreement);
            }
        }
        return tenantAgreements;
    }

    public List<RentalAgreement> getRentalAgreementsForLandlord(Landlord landlord) {
        List<RentalAgreement> landlordAgreements = new ArrayList<>();
        for (RentalAgreement agreement : rentalAgreements) {
            if (agreement.getProperty().getLandLordId() == landlord.getId()) {
                landlordAgreements.add(agreement);
            }
        }
        return landlordAgreements;
    }

    // Get tenants and landlords by name
    public Tenant getTenantByName(String name) {
        return tenants.values().stream()
                .filter(tenant -> tenant.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public Landlord getLandlordByName(String name) {
        return landlords.values().stream()
                .filter(landlord -> landlord.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    // Get landlord by ID
    public Landlord findLandlordById(int id) throws LandlordNotFoundException {
        Landlord landlord = landlords.get(id);
        if (landlord == null) {
            throw new LandlordNotFoundException("Landlord not found with ID: " + id);
        }
        return landlord;
    }

    // Method to demonstrate Local Variable Type Inference (LVTI)
    public void displayPropertyDetails(int propertyId) {
        try {
            var property = findPropertyById(propertyId); // Using 'var' for local variable
            var details = String.format("Property ID: %d, Address: %s, Rent Price: %.2f, Available: %b",
                    ((Property) property).getId(), property.getAddress(), property.getRentPrice(),
                    property.isAvailable());
            System.out.println(details);
        } catch (PropertyNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public List<PropertyInterface> searchProperties(Predicate<PropertyInterface> predicate) {
        return properties.stream().filter(predicate).collect(Collectors.toList());
    }

    public PropertyInterface findPropertyById(int id) throws PropertyNotFoundException {
        return properties.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new PropertyNotFoundException("Property not found with ID: " + id));
    }

    public PropertyInterface findPropertyByAddress(String address) throws PropertyNotFoundException {
        return properties.stream()
                .filter(p -> p.getAddress().equalsIgnoreCase(address))
                .findFirst()
                .orElseThrow(() -> new PropertyNotFoundException("Property not found: " + address));
    }

    // Method to demonstrate call-by-value
    public void modifyTenantName(Tenant tenant, String newName) {
        tenant.setName(newName); // This will modify the original tenant object
    }

    // Method to demonstrate defensive copying
    public Tenant getTenantCopy(int tenantId) {
        Tenant originalTenant = tenants.get(tenantId);
        if (originalTenant == null) {
            return null;
        }
        // Create a defensive copy of the tenant
        return new Tenant(originalTenant.getName(), originalTenant.getEmail(), originalTenant.getId());
    }

    // Method for landlord to update property price
    public void updatePropertyPrice(int propertyId, double newPrice) throws PropertyNotFoundException {
        Property property = (Property) findPropertyById(propertyId);
        property.setRentPrice(newPrice);
    }

    // Method to create a copy of an existing property
    public Property getPropertyCopy(int propertyId) throws PropertyNotFoundException {
        Property originalProperty = (Property) findPropertyById(propertyId);
        if (originalProperty instanceof Apartment) {
            Apartment originalApartment = (Apartment) originalProperty;
            return new Apartment(originalApartment.getId(), originalApartment.getAddress(),
                    originalApartment.getRentPrice(), originalApartment.isAvailable(), originalApartment.getType(),
                    originalApartment.getFloorNumber(), originalApartment.getLandLordId());
        } else if (originalProperty instanceof House) {
            House originalHouse = (House) originalProperty;
            return new House(originalHouse.getId(), originalHouse.getAddress(), originalHouse.getRentPrice(),
                    originalHouse.isAvailable(), PropertyType.HOUSE, originalHouse.hasGarden(),
                    originalHouse.getLandLordId());
        } else {
            throw new IllegalArgumentException("Unknown property type");
        }
    }

    public ImmutableProperty createImmutableProperty(int propertyId) throws PropertyNotFoundException {
        Property property = (Property) findPropertyById(propertyId);
        return new ImmutableProperty(property.getId(), property.getAddress(), property.getRentPrice(),
                property.isAvailable());
    }

}
