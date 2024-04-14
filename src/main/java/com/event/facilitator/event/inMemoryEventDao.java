package com.event.facilitator.event;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class inMemoryEventDao {
    private final List<Event> events = new ArrayList<>();
    inMemoryEventDao(){
        events.add( new Event(1,
                "patna",
                "Bihar",
                803110,
                "India",
                "maharajaHall",
                "maharajaHallCompany",
                58,
                true,
                58,
                38000,
                true,
                false,
                "this is great hotel",
                "7371857426",
                "kumardiwanhshu00@gmail.com"));
        events.add(new Event(2,
                "nalanda",
                "Bihar",
                803111,
                "India",
                "banquetHall",
                "surajHotels",
                108,
                false,
                39,
                50000,
                true,
                false,
                "this is great hotel",
                "8409654492",
                "priyanshukumar446@gmail.com")

        );
    }
    public Event save(Event event) {
        events.add(event);
        return event;
    }

    public List<Event> findAllEvent(){
        return events;
    }

    public Event findEventByID(int hallId) {
        return events.stream().
                filter(event -> hallId==event.getHallId()).findFirst().
                orElse(null);
    }

    public Event update(Event event) {
        var eventIndex = IntStream.range(0,events.size())
                .filter(index -> events.get(index).getHallId()==event.getHallId()).findFirst()
                .orElse(-1);

        if(eventIndex>-1){
            events.set(eventIndex,event);
            return event;
        }
        return null;
    }

    public void delete(int hallId) {
        var event = findEventByID(hallId);
        if(event!=null){
            events.remove(event);
        }
    }
}
