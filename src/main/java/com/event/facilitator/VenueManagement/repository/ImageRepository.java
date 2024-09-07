package com.event.facilitator.VenueManagement.repository;

import com.event.facilitator.VenueManagement.dto.ImageDTO;
import com.event.facilitator.VenueManagement.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    boolean existsByVenueId(long venueId);

    ImageDTO findFirstByVenueId(long imageId);

    List<ImageDTO> findByVenueId(long venueId);
}
