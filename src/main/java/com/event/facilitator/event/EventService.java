package com.event.facilitator.event;

import org.springframework.stereotype.Service;

import java.util.List;


public interface EventService {
    Event save(Event event);
    List<Event> findAllEvent();
    Event findEventByID(int hallId);
    Event update(Event event);
    void delete(int hallId);
}
