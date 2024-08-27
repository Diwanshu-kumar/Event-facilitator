package com.event.facilitator.booking.dto;

import java.time.LocalDate;

public record BookingRequest(long venueId, long userId, LocalDate startDate, LocalDate endDate) {
}
