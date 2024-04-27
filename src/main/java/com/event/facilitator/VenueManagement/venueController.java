package com.event.facilitator.VenueManagement;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/events")
public class venueController {
    private final VenueService eventService;
    public venueController(VenueService eventService){
        this.eventService = eventService;
    }
    @GetMapping
    public List<Venue> getAllEvent(){
        return eventService.findAllEvent();
    }

    @PostMapping
    public Venue save(@RequestBody Venue venue){
        return eventService.save(venue);
    }
    @GetMapping("/{hallId}")
    public Venue findEventById(@PathVariable int hallId){
        return eventService.findEventByID(hallId);
    }
    @PutMapping
    public Venue update(@RequestBody Venue venue){
        return eventService.update(venue);
    }

    @DeleteMapping("/{hallId}")
    public void delete(@PathVariable int hallId){
        eventService.delete(hallId);
    }
}
