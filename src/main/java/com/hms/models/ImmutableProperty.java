package com.hms.models;

public final class ImmutableProperty {
    private final int id;
    private final String address;
    private final double rentPrice;
    private final boolean isAvailable;

    public ImmutableProperty(int id, String address, double rentPrice, boolean isAvailable) {
        this.id = id;
        this.address = address;
        this.rentPrice = rentPrice;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "ImmutableProperty{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", rentPrice=" + rentPrice +
                ", isAvailable=" + isAvailable +
                '}';
    }
}