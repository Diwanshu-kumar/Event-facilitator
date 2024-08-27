package com.event.facilitator.booking.repository;

import com.event.facilitator.VenueManagement.entity.Venue;
import com.event.facilitator.booking.entity.Booking;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Long> {


    List<Booking> findByVenueIdAndStartDateBetweenOrVenueIdAndEndDateBetween(long venueId, LocalDate startStartDate, LocalDate endStartDate
            ,long venueId1, LocalDate startEndDate, LocalDate endEndDate);
}
