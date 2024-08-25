package com.event.facilitator.VenueManagement.dto;

import com.event.facilitator.VenueManagement.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public record VenueRequest(String name,
                           String type,
                           String city,
                           String capacity,
                           String parkingCapacity,
                           String price,
                           String dimensions,
                           String shortDescription,
                           String description,
                           String phone,
                           String email,
                           List<Long> amenityIds,
                           String address,
                           List<MultipartFile> image
                        ) {
}
