package com.event.facilitator.event;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class inMemoryEventService implements EventService {
    private final inMemoryEventDao dao;

    public inMemoryEventService(inMemoryEventDao dao) {
        this.dao = dao;
    }

    @Override
    public Event save(Event event) {
        return dao.save(event);
    }

    @Override
    public List<Event> findAllEvent(){
        return dao.findAllEvent();
    }

    @Override
    public Event findEventByID(int hallId) {
        return dao.findEventByID(hallId);
    }

    @Override
    public Event update(Event event) {
        return dao.update(event);
    }

    @Override
    public void delete(int hallId) {
        dao.delete(hallId);
    }
}
