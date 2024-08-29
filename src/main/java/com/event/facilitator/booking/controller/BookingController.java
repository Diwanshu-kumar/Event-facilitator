package com.event.facilitator.booking.controller;

import com.event.facilitator.booking.dto.BookingHistoryResponse;
import com.event.facilitator.booking.dto.BookingRequest;
import com.event.facilitator.booking.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

    BookingService bookingService;
    public BookingController( BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/bookVenue")
    public ResponseEntity<String> bookNow(@RequestBody BookingRequest bookingRequest) {
        return bookingService.createBooking(bookingRequest);
    }

    @GetMapping("/history")
    public ResponseEntity<List<BookingHistoryResponse>> bookHistory(@RequestParam long userId) {
        List<BookingHistoryResponse> bookingHistoryResponses = bookingService.getBookingHistory(userId);
        return ResponseEntity.ok(bookingHistoryResponses);
    }
    @PostMapping("/cancelBooking")
    public ResponseEntity<String > cancelBooking(@RequestParam long bookingId) {
        System.out.println(bookingId);
        String message =  bookingService.cancelBooking(bookingId);
        return ResponseEntity.ok(message);
    }
}
