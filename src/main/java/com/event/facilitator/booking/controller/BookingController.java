package com.event.facilitator.booking.controller;

import com.event.facilitator.booking.dto.BookingRequest;
import com.event.facilitator.booking.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    BookingService bookingService;
    public BookingController( BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/bookVenue")
    public ResponseEntity<String> bookNow(@RequestBody BookingRequest bookingRequest) {
        return bookingService.createBooking(bookingRequest);
    }
}
