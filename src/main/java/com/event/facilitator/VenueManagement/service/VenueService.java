package com.event.facilitator.VenueManagement.service;

import com.event.facilitator.VenueManagement.dto.ImageDTO;
import com.event.facilitator.VenueManagement.dto.VenueInfoDTO;
import com.event.facilitator.VenueManagement.dto.VenueRequest;
import com.event.facilitator.VenueManagement.entity.Amenity;
import com.event.facilitator.VenueManagement.entity.Image;
import com.event.facilitator.VenueManagement.entity.Venue;
import com.event.facilitator.VenueManagement.repository.AmenityRepository;
import com.event.facilitator.VenueManagement.repository.ImageRepository;
import com.event.facilitator.VenueManagement.repository.VenueRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class VenueService {

    private final VenueRepository venueRepository;
    private final AmenityRepository amenityRepository;
    private final ImageRepository imageRepository;

    public VenueService(VenueRepository venueRepository, AmenityRepository amenityRepository, ImageRepository imageRepository) {
        this.venueRepository = venueRepository;
        this.amenityRepository = amenityRepository;
        this.imageRepository = imageRepository;
    }

    Random random = new Random();
    public Page<VenueInfoDTO> getAllVenues(int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        Page<Venue> venuePage = venueRepository.findAll(pageable);
        return getLimitedVenuesInfo(venuePage);
    }

    private Page<VenueInfoDTO> getLimitedVenuesInfo(Page<Venue> venues) {
        List<VenueInfoDTO> venueInfoDTOList = new ArrayList<>();

        // Convert Venue to VenueInfoDTO
        for (Venue venue : venues) {
            VenueInfoDTO venueInfoDTO = new VenueInfoDTO(
                    venue.getId(),
                    venue.getName(),
                    venue.getCity(),
                    venue.getCapacity(),
                    venue.getPrice(),
                    venue.getPhone(),
                    venue.getAmenities()
            );
            venueInfoDTOList.add(venueInfoDTO);
        }

        // Create a PageImpl object using the list and the original pageable object
        Pageable pageable = venues.getPageable();
        return new PageImpl<>(venueInfoDTOList, pageable, venues.getTotalElements());
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
        venueRepository.save(venue);
    }

    public Venue getVenueById(long id) {
        return venueRepository.findVenuesById(id);

    }

    public Page<VenueInfoDTO> getVenueByName(String name, int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Venue> venuePage = venueRepository.findByNameContainingIgnoreCase(name,pageable);
        return getLimitedVenuesInfo(venuePage);
    }

    public Page<VenueInfoDTO> getVenueByType(String type, int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Venue> venues = venueRepository.findByTypeContainingIgnoreCase(type,pageable);
        return getLimitedVenuesInfo(venues);
    }
    public Page<VenueInfoDTO> getVenueInfoByNameAndType(String name, String type, int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Venue> venues = venueRepository.findByNameContainingIgnoreCaseAndType(name,type,pageable);
        return getLimitedVenuesInfo(venues);
    }

    public ImageDTO getImage(long venueId) {
        if(imageRepository.existsByVenueId(venueId)){
            return imageRepository.findFirstByVenueId(venueId);
        }
        return new ImageDTO(null,null);
    }

    public List<ImageDTO> getAllImages(long venueId) {
        if(imageRepository.existsByVenueId(venueId)){
            return imageRepository.findByVenueId(venueId);
        }
        return new ArrayList<>();
    }
}
