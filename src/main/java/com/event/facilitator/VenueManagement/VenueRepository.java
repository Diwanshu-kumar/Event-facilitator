package com.event.facilitator.VenueManagement;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VenueRepository extends JpaRepository<Venue, Integer> {
        List<Venue> findVenueByProviderId(int providerId);
}
