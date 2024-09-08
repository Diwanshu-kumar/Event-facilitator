package com.event.facilitator.VenueManagement.repository;

import com.event.facilitator.VenueManagement.entity.Venue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {

    Venue findVenuesById(long id);

    Page<Venue> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<Venue> findByNameContainingIgnoreCaseAndType(String name, String type,Pageable pageable);

    Page<Venue> findByTypeContainingIgnoreCase(String type,Pageable pageable);
}
