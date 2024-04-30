package com.event.facilitator.bookingModule;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceIMPL implements BookingService{

    BookingRepository bookingRepository;
    public BookingServiceIMPL(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public ResponseEntity<String> bookVenue(Booking booking) {
        if(bookingRepository.existsByVenueIdAndBookingDate(booking.getVenueId(), booking.getBookingDate()))
            return ResponseEntity.ok("venue is not available on given date");
        bookingRepository.save(booking);
        return ResponseEntity.ok("booking is successful");
    }
}
