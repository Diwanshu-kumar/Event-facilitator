package com.event.facilitator.VenueManagement.controller;

import com.event.facilitator.VenueManagement.dto.VenueInfoDTO;
import com.event.facilitator.VenueManagement.dto.VenueRequest;
import com.event.facilitator.VenueManagement.entity.Venue;
import com.event.facilitator.VenueManagement.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<VenueInfoDTO>> getVenues(){
        return ResponseEntity.ok(venueService.getAllVenues());
    }

    @GetMapping("/details")
    public ResponseEntity<Venue> getVenueById(@RequestParam long id){
        Venue venue = venueService.getVenueById(id);
        if(venue==null){
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(venue);
    }
}
