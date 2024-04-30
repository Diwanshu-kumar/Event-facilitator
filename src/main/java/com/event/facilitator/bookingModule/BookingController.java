package com.event.facilitator.bookingModule;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/venue/user")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    ResponseEntity<String > booking(@RequestBody Booking booking){
        return bookingService.bookVenue(booking);
    }
}
