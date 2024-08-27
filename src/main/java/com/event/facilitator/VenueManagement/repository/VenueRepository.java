package com.event.facilitator.VenueManagement.repository;

import com.event.facilitator.VenueManagement.dto.VenueInfoDTO;
import com.event.facilitator.VenueManagement.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VenueRepository extends JpaRepository<Venue, Long> {

    Venue findVenuesById(long id);

    List<Venue> findByNameContainingIgnoreCase(String name);

    List<Venue> findByNameContainingIgnoreCaseAndType(String name, String type);

    List<Venue> findByTypeContainingIgnoreCase(String type);
}
