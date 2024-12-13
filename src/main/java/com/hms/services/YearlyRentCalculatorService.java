package com.hms.services;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.StructuredTaskScope;
import java.lang.ScopedValue;

/**
 * Service class for calculating yearly rent and managing rental properties.
 */
public class YearlyRentCalculatorService {

    // ScopedValue to pass context (like tenant info) to methods in a controlled way
    private static final ScopedValue<String> CURRENT_TENANT = ScopedValue.newInstance();
    public double calculateYearlyRent(double monthlyRent) {
        return monthlyRent * 12;
    }

    /**
     * Calculates yearly rent for multiple properties using Structured Concurrency with virtual threads.
     */
    public Map<String, Double> calculateYearlyRentForProperties(Map<String, Double> properties) throws Exception {
        Map<String, Double> yearlyRents = new LinkedHashMap<>();

        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            for (var entry : properties.entrySet()) {
                scope.fork(() -> {
                    String property = entry.getKey();
                    double monthlyRent = entry.getValue();
                    yearlyRents.put(property, calculateYearlyRent(monthlyRent));
                    return null;
                });
            }
            scope.join(); // Wait for all tasks to complete
        }

        return yearlyRents;
    }

    /**
     *  Calculate yearly rent within a specific tenant's context using ScopedValues.
     */
    public double calculateYearlyRentForTenant(String tenantName, double monthlyRent) {
        return ScopedValue.where(CURRENT_TENANT, tenantName).call(() -> {
            System.out.println("Calculating rent for tenant: " + CURRENT_TENANT.get());
            return calculateYearlyRent(monthlyRent);
        });
    }
}
