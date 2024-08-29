package com.event.facilitator.booking.dto;

import java.time.LocalDate;

public class BookingHistoryResponse {
    private long bookingId;
    private long venueId;
    private String venueName;
    private String venueAddress;
    private String city;
    private String capacity;
    private String venueCity;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    public BookingHistoryResponse(long bookingId, long venueId, String venueName, String venueAddress, String city, String capacity, String venueCity, LocalDate startDate, LocalDate endDate, String status) {
        this.bookingId = bookingId;
        this.venueId = venueId;
        this.venueName = venueName;
        this.venueAddress = venueAddress;
        this.city = city;
        this.capacity = capacity;
        this.venueCity = venueCity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public long getVenueId() {
        return venueId;
    }

    public void setVenueId(long venueId) {
        this.venueId = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueAddress() {
        return venueAddress;
    }

    public void setVenueAddress(String venueAddress) {
        this.venueAddress = venueAddress;
    }

    public String getVenueCity() {
        return venueCity;
    }

    public void setVenueCity(String venueCity) {
        this.venueCity = venueCity;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
