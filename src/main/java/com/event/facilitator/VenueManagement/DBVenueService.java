package com.event.facilitator.VenueManagement;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBVenueService implements VenueService {

    private final VenueRepository venRepo;

    public DBVenueService(VenueRepository venRepo) {
        this.venRepo = venRepo;
    }
    @Override
    public Venue save(Venue venue) {
        venRepo.save(venue);
        return venue;
    }

    @Override
    public List<Venue> findAllVenue() {
        return venRepo.findAll();
    }

    @Override
    public Venue findVenueByID(int venueId) {
        return venRepo.findById(venueId).get();
    }

    @Override
    public Venue update(Venue venue) {
        venRepo.save(venue);
        return venue;
    }

    @Override
    public void delete(int venueId) {
        venRepo.deleteById(venueId);
    }
}
