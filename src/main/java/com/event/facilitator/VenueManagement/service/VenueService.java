package com.event.facilitator.VenueManagement.service;

import com.event.facilitator.VenueManagement.dto.VenueInfoDTO;
import com.event.facilitator.VenueManagement.dto.VenueRequest;
import com.event.facilitator.VenueManagement.entity.Amenity;
import com.event.facilitator.VenueManagement.entity.Image;
import com.event.facilitator.VenueManagement.entity.Venue;
import com.event.facilitator.VenueManagement.repository.AmenityRepository;
import com.event.facilitator.VenueManagement.repository.VenueRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class VenueService {

    private final VenueRepository venueRepository;
    private final AmenityRepository amenityRepository;

    public VenueService(VenueRepository venueRepository, AmenityRepository amenityRepository) {
        this.venueRepository = venueRepository;
        this.amenityRepository = amenityRepository;
    }

    Random random = new Random();
    public List<VenueInfoDTO> getAllVenues() {
        List<Venue> venues = venueRepository.findAll();
        List<VenueInfoDTO> venueInfoDTOList = new ArrayList<>();
        for (Venue venue : venues) {
            VenueInfoDTO venueInfoDTO = new VenueInfoDTO(
                    venue.getId()
                    ,venue.getName(),
                    venue.getCity(),
                    venue.getCapacity(),
                    venue.getPrice(),
                    venue.getAmenities(),
                    venue.getImages().isEmpty()?null:venue.getImages().get(random.nextInt(venue.getImages().size())));
            venueInfoDTOList.add(venueInfoDTO);
        }
        return venueInfoDTOList;
    }

    public void saveVenueWithDetails(VenueRequest venueRequest) throws IOException {
        Venue venue = new Venue();
        venue.setName(venueRequest.name());
        venue.setType(venueRequest.type());
        venue.setAddress(venueRequest.address());
        venue.setCity(venueRequest.city());
        venue.setCapacity(venueRequest.capacity());
        venue.setParkingCapacity(venueRequest.parkingCapacity());
        venue.setPhone(venueRequest.phone());
        venue.setShortDescription(venueRequest.shortDescription());
        venue.setDescription(venueRequest.description());
        venue.setEmail(venueRequest.email());
        venue.setPrice(venueRequest.price());
        venue.setDimensions(venueRequest.dimensions());

        List<Image> imageList = new ArrayList<>();
        if(venueRequest.image()!=null) {
            for (MultipartFile image : venueRequest.image()) {
                Image img = new Image();
                img.setFileName(image.getOriginalFilename());
                img.setData(image.getBytes());
                imageList.add(img);
            }
        }

        Set<Amenity> amenities = new HashSet<>();
        if(venueRequest.amenityIds()!=null) {
            for (Long amenityId : venueRequest.amenityIds()) {
                if (amenityRepository.existsById(amenityId)) {
                    amenities.add(amenityRepository.findById(amenityId).get());
                }
            }
        }
        venue.setImages(imageList);
        venue.setAmenities(amenities);
        return venueRepository.save(venue);
    }

    public Venue getVenueById(long id) {
        return venueRepository.findVenuesById(id);

    }
}
