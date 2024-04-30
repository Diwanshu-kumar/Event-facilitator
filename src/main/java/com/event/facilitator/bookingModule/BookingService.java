package com.event.facilitator.bookingModule;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {
    ResponseEntity<String > bookVenue(Booking booking);
}
