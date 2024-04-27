package com.event.facilitator.VenueManagement;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class inMemoryVenueDao {
    private final List<Venue> venues = new ArrayList<>();
    inMemoryVenueDao(){
        venues.add( new Venue(1,
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
                "kumardiwanhshu00@gmail.com",
                ""));

        venues.add(new Venue(2,
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
                "priyanshukumar446@gmail.com",
                "")

        );
    }
    public Venue save(Venue venue) {
        venues.add(venue);
        return venue;
    }

    public List<Venue> findAllEvent(){
        return venues;
    }

    public Venue findEventByID(int hallId) {
        return venues.stream().
                filter(venue -> hallId== venue.getHallId()).findFirst().
                orElse(null);
    }

    public Venue update(Venue venue) {
        var eventIndex = IntStream.range(0, venues.size())
                .filter(index -> venues.get(index).getHallId()== venue.getHallId()).findFirst()
                .orElse(-1);

        if(eventIndex>-1){
            venues.set(eventIndex, venue);
            return venue;
        }
        return null;
    }

    public void delete(int hallId) {
        var event = findEventByID(hallId);
        if(event!=null){
            venues.remove(event);
        }
    }
}
