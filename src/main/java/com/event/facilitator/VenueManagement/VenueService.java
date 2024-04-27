package com.event.facilitator.VenueManagement;

import java.util.List;


public interface VenueService {
    Venue save(Venue venue);
    List<Venue> findAllEvent();
    Venue findEventByID(int hallId);
    Venue update(Venue venue);
    void delete(int hallId);
}
