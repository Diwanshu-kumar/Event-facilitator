package com.event.facilitator.VenueManagement.dto;

import com.event.facilitator.VenueManagement.entity.Amenity;
import com.event.facilitator.VenueManagement.entity.Image;

import java.util.List;
import java.util.Set;

public record VenueInfoDTO(
         Long id,

         String name,

         String city,
         String capacity,
         String price,
         String phone,

         Set<Amenity> amenities
//         Image img
) {
}
