package com.event.facilitator.VenueManagement;

public class Venue {
    public Venue() {}

    private int venueId;
    private int providerId;
    private String venueName;
    private String city;
    private String district;
    private String state;
    private int pinCode;
    private String country;
    private int noOfSeats;
    private int parkingCapacity;
    private String acAvailable;
    private String djAvailable;
    private String managerName;
    private String contactNumber;
    private String managerEmail;
    private String imgSrc;
    private String description;
    private int price;

    public Venue(int venueId, int providerId, String venueName, String city, String district, String state, int pinCode, String country, int noOfSeats, int parkingCapacity, String acAvailable, String djAvailable, String managerName, String contactNumber, String managerEmail, String imgSrc, String description, int price) {
        this.venueId = venueId;
        this.providerId = providerId;
        this.venueName = venueName;
        this.city = city;
        this.district = district;
        this.state = state;
        this.pinCode = pinCode;
        this.country = country;
        this.noOfSeats = noOfSeats;
        this.parkingCapacity = parkingCapacity;
        this.acAvailable = acAvailable;
        this.djAvailable = djAvailable;
        this.managerName = managerName;
        this.contactNumber = contactNumber;
        this.managerEmail = managerEmail;
        this.imgSrc = imgSrc;
        this.description = description;
        this.price = price;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
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

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public int getParkingCapacity() {
        return parkingCapacity;
    }

    public void setParkingCapacity(int parkingCapacity) {
        this.parkingCapacity = parkingCapacity;
    }

    public String getAcAvailable() {
        return acAvailable;
    }

    public void setAcAvailable(String acAvailable) {
        this.acAvailable = acAvailable;
    }

    public String getDjAvailable() {
        return djAvailable;
    }

    public void setDjAvailable(String djAvailable) {
        this.djAvailable = djAvailable;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
