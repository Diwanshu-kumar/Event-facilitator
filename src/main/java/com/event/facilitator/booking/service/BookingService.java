package com.event.facilitator.booking.service;

import com.event.facilitator.VenueManagement.entity.Venue;
import com.event.facilitator.VenueManagement.repository.VenueRepository;
import com.event.facilitator.booking.dto.BookingHistoryResponse;
import com.event.facilitator.booking.dto.BookingRequest;
import com.event.facilitator.booking.entity.Booking;
import com.event.facilitator.booking.repository.BookingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    private final VenueRepository venueRepository;

    public BookingService(BookingRepository bookingRepository, VenueRepository venueRepository) {
        this.bookingRepository = bookingRepository;
        this.venueRepository = venueRepository;
    }

    public ResponseEntity<String > createBooking(BookingRequest request) {
        // Validate dates
        if (request.startDate().isAfter(request.endDate())) {
            return ResponseEntity.badRequest().body( "Start date must be before end date");
        }

        // Check venue availability
        List<Booking> existingBookings = bookingRepository.findByVenueIdAndStartDateBetweenAndStatusEqualsOrVenueIdAndEndDateBetweenAndStatusEquals(
                request.venueId(), request.startDate(), request.endDate(), "confirmed"
                ,request.venueId(),request.startDate(),request.endDate(),"confirmed");

        if (!existingBookings.isEmpty()) {
            return ResponseEntity.badRequest().body( "Venue is not available for the selected dates.");
        }

        // Create booking
        Venue venue = venueRepository.findById(request.venueId()).orElse(null);
        if (venue == null) {
            return  ResponseEntity.badRequest().body( "Venue not found.");
        }
        Booking booking = new Booking();
        booking.setVenue(venue);
        booking.setStartDate(request.startDate());
        booking.setEndDate(request.endDate());
        booking.setUserId(request.userId());
        booking.setStatus("confirmed");

        bookingRepository.save(booking);
        return ResponseEntity.ok().body( "venue "+ venue.getName()+" booked successfully");
    }

    public List<BookingHistoryResponse> getBookingHistory(long userId) {
        List<BookingHistoryResponse> bookingHistoryResponses = bookingRepository.bookingHistory(userId);
        bookingHistoryResponses.sort(Comparator.comparing(BookingHistoryResponse::getStartDate));
        return bookingHistoryResponses;
    }

    public String cancelBooking(long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        if (booking == null) {
            return "Booking not found";
        }
        if(booking.getStatus().equals("cancelled")){
            return "Booking is not available";
        }
        booking.setStatus("cancelled");
        bookingRepository.save(booking);

        return "Booking cancelled successfully";
    }
}
