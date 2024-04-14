package com.event.facilitator.event;

public class Event {
    public Event() {
    }
//    private int providerId;
    private int hallId;
    private String city;
    private String state;
    private int pincode;
    private String country;
    private String hallName;
    private String providerName;
    private int noOfSeats;
    private boolean acAvailable;
    private int parkingCapacity;
    private int price;
    private boolean djAvailable;
    private boolean alcoholAvailable;
    private String description;
    private String  contactNumber;
    private String email;

    public Event(
            int hallId, String city, String state,
            int pincode, String country,
            String hallName, String providerName, int noOfSeats,
            boolean acAvailable, int parkingCapacity, int price,
            boolean djAvailable, boolean alcoholAvailable,
            String description, String  contactNumber, String email) {
        this.hallId = hallId;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.country = country;
        this.hallName = hallName;
        this.providerName = providerName;
        this.noOfSeats = noOfSeats;
        this.acAvailable = acAvailable;
        this.parkingCapacity = parkingCapacity;
        this.price = price;
        this.djAvailable = djAvailable;
        this.alcoholAvailable = alcoholAvailable;
        this.description = description;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public boolean isAcAvailable() {
        return acAvailable;
    }

    public void setAcAvailable(boolean acAvailable) {
        this.acAvailable = acAvailable;
    }

    public int getParkingCapacity() {
        return parkingCapacity;
    }

    public void setParkingCapacity(int parkingCapacity) {
        this.parkingCapacity = parkingCapacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isDjAvailable() {
        return djAvailable;
    }

    public void setDjAvailable(boolean djAvailable) {
        this.djAvailable = djAvailable;
    }

    public boolean isAlcoholAvailable() {
        return alcoholAvailable;
    }

    public void setAlcoholAvailable(boolean alcoholAvailable) {
        this.alcoholAvailable = alcoholAvailable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String  contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
