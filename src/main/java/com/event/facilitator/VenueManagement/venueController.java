package com.event.facilitator.VenueManagement;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/venue")
public class venueController {
    private final VenueService venueService;
    public venueController(@Qualifier("DBVenueService") VenueService venueService){
        this.venueService = venueService;
    }
    @GetMapping
    public List<Venue> getAllVenue(){
        return venueService.findAllVenue();
    }

    @PostMapping
    public Venue save(@RequestBody Venue venue){
        return venueService.save(venue);
    }

    @GetMapping("/{venueId}")
    public Venue findVenueByID(@PathVariable int venueId){
        return venueService.findVenueByID(venueId);
    }

    @GetMapping("/providerId/{providerId}")
    public List<Venue> findVenueByProviderId(@PathVariable int providerId){
        return venueService.findVenueByProviderId(providerId);
    }

    @PutMapping
    public Venue update(@RequestBody Venue venue){
        return venueService.update(venue);
    }

    @DeleteMapping("/{venueId}")
    public void delete(@PathVariable int venueId){
        venueService.delete(venueId);
    }
}
