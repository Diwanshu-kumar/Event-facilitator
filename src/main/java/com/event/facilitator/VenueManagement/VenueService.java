package com.event.facilitator.VenueManagement;

import java.util.List;


public interface VenueService {
    Venue save(Venue venue);
    List<Venue> findAllVenue();
    Venue findVenueByID(int venueId);
    Venue update(Venue venue);
    void delete(int venueId);
}
