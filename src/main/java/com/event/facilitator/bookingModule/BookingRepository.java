package com.event.facilitator.bookingModule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Date;

@EnableJpaRepositories
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    boolean existsByVenueIdAndBookingDate(int venueId, Date bookingDate);
}
