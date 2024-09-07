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
    public List<VenueInfoDTO> getAllVenues() {
        List<Venue> venues = venueRepository.findAll();
        return getLimitedVenuesInfo(venues);
    }

    private List<VenueInfoDTO> getLimitedVenuesInfo(List<Venue> venues){
        List<VenueInfoDTO> venueInfoDTOList = new ArrayList<>();
        for (Venue venue : venues) {
            VenueInfoDTO venueInfoDTO = new VenueInfoDTO(
                    venue.getId()
                    ,venue.getName(),
                    venue.getCity(),
                    venue.getCapacity(),
                    venue.getPrice(),
                    venue.getPhone(),
                    venue.getAmenities());
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
        venueRepository.save(venue);
    }

    public Venue getVenueById(long id) {
        return venueRepository.findVenuesById(id);

    }

    public List<VenueInfoDTO> getVenueByName(String name){
        List<Venue> venues =  venueRepository.findByNameContainingIgnoreCase(name);
        return getLimitedVenuesInfo(venues);
    }

    public List<VenueInfoDTO> getVenueByType(String type){
        List<Venue> venues = venueRepository.findByTypeContainingIgnoreCase(type);
        return getLimitedVenuesInfo(venues);
    }
    public List<VenueInfoDTO> getVenueInfoByNameAndType(String name,String type){
        List<Venue> venues = venueRepository.findByNameContainingIgnoreCaseAndType(name,type);
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
