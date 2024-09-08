package com.event.facilitator.VenueManagement.controller;

import com.event.facilitator.VenueManagement.dto.ImageDTO;
import com.event.facilitator.VenueManagement.dto.VenueInfoDTO;
import com.event.facilitator.VenueManagement.dto.VenueRequest;
import com.event.facilitator.VenueManagement.dto.VenueSearchRequestDTO;
import com.event.facilitator.VenueManagement.entity.Venue;
import com.event.facilitator.VenueManagement.service.VenueService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/venues")
public class VenueController {


    private final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @PostMapping("/venues")
    public ResponseEntity<String> uploadVenueWithImages(@ModelAttribute VenueRequest venueRequest) {
        try {
            venueService.saveVenueWithDetails(venueRequest);
            return ResponseEntity.ok("Venue added successfully");
        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/venues")
    public ResponseEntity<Page<VenueInfoDTO>> getVenues(@RequestParam(defaultValue = "0") int pageNumber,
                                                        @RequestParam(defaultValue = "3") int pageSize){
        Page<VenueInfoDTO> venueInfoDTOPage = venueService.getAllVenues(pageNumber,pageSize);

        return ResponseEntity.ok(venueInfoDTOPage);
    }

    @GetMapping("/details")
    public ResponseEntity<Venue> getVenueById(@RequestParam long id){
        Venue venue = venueService.getVenueById(id);
        if(venue==null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(venue);
    }

    @PostMapping("/resource/search")
    public ResponseEntity<Page<VenueInfoDTO>> getVenueInfoByFilter(@RequestBody VenueSearchRequestDTO venueSearchRequestDTO,
                                                                   @RequestParam(defaultValue = "0") int pageNumber,
                                                                   @RequestParam(defaultValue = "2")int pageSize){
//        System.out.println(venueSearchRequestDTO);
        String venueName = venueSearchRequestDTO.name();
        String type = venueSearchRequestDTO.type();
        String date = venueSearchRequestDTO.date();

        Page<VenueInfoDTO> result = null;
        if(!venueName.isEmpty() && !type.isEmpty() && !date.isEmpty()){

        }else if(!venueName.isEmpty() && !type.isEmpty()){
            result =venueService.getVenueInfoByNameAndType(venueName,type,pageNumber,pageSize);
        }else if(!venueName.isEmpty()){
            result = venueService.getVenueByName(venueName,pageNumber,pageSize);
        }else if(!type.isEmpty()){
            result = venueService.getVenueByType(type,pageNumber,pageSize);
        }
        return  ResponseEntity.ok( result);
    }

    @GetMapping("/resource/image")
    public ResponseEntity<ImageDTO> getImage(@RequestParam long venueId){
        return ResponseEntity.ok(venueService.getImage(venueId));
    }

    @GetMapping("/resource/images")
    public ResponseEntity<List<ImageDTO>> getImages(@RequestParam long venueId){
        List<ImageDTO> result = venueService.getAllImages(venueId);
        return ResponseEntity.ok(result);
    }
}
