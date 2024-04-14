package com.event.facilitator.event;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/events")
public class eventController {
    private final EventService eventService;
    public eventController(EventService eventService){
        this.eventService = eventService;
    }
    @GetMapping
    public List<Event> getAllEvent(){
        return eventService.findAllEvent();
    }

    @PostMapping
    public Event save(@RequestBody Event event){
        return eventService.save(event);
    }
    @GetMapping("/{hallId}")
    public Event findEventById(@PathVariable int hallId){
        return eventService.findEventByID(hallId);
    }
    @PutMapping
    public Event update(@RequestBody Event event){
        return eventService.update(event);
    }

    @DeleteMapping("/{hallId}")
    public void delete(@PathVariable int hallId){
        eventService.delete(hallId);
    }
}
