package com.event.facilitator.VenueManagement;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class inMemoryVenueService implements VenueService {
    private final inMemoryVenueDao dao;

    public inMemoryVenueService(inMemoryVenueDao dao) {
        this.dao = dao;
    }

    @Override
    public Venue save(Venue venue) {
        return dao.save(venue);
    }

    @Override
    public List<Venue> findAllVenue(){
        return dao.findAllVenue();
    }

    @Override
    public Venue findVenueByID(int hallId) {
        return dao.findVenueByID(hallId);
    }

    @Override
    public Venue update(Venue venue) {
        return dao.update(venue);
    }

    @Override
    public void delete(int venueId) {
        dao.delete(venueId);
    }
}
