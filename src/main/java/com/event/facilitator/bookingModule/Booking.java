package com.event.facilitator.bookingModule;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingID;
    private int venueId;
    private int userId;
    private Date bookingDate;

    public Booking() {
    }
    public Booking(int bookingID, int venueId, int userId, Date bookingDate) {
        this.bookingID = bookingID;
        this.venueId = venueId;
        this.userId = userId;
        this.bookingDate = bookingDate;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
}
