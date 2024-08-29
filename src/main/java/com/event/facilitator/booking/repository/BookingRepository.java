package com.event.facilitator.booking.repository;

import com.event.facilitator.VenueManagement.entity.Venue;
import com.event.facilitator.booking.dto.BookingHistoryResponse;
import com.event.facilitator.booking.entity.Booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends CrudRepository<Booking, Long> {


    List<Booking> findByVenueIdAndStartDateBetweenAndStatusEqualsOrVenueIdAndEndDateBetweenAndStatusEquals(
            long venueId, LocalDate startStartDate, LocalDate endStartDate, String status1
            ,long venueId1, LocalDate startEndDate, LocalDate endEndDate, String status2);

    @Query("SELECT new com.event.facilitator.booking.dto.BookingHistoryResponse(" +
           "b.id, v.id, v.name, v.address, v.city, v.capacity, v.city, " +
           "b.startDate, b.endDate, b.status) " +
           "FROM Booking b " +
           "LEFT JOIN b.venue v " +
           "WHERE b.userId = :userId " +
           "GROUP BY b.id, v.id, v.name, v.address, v.city, v.capacity, b.startDate, b.endDate")
    List<BookingHistoryResponse> bookingHistory(@Param("userId") long userId);

}
