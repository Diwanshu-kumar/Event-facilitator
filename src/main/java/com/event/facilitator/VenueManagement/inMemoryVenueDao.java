package com.event.facilitator.VenueManagement;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class inMemoryVenueDao {
    private final List<Venue> venues = new ArrayList<>();
    inMemoryVenueDao(){
        venues.add( new Venue(
                1,
                1,
                "maharajaHall",
                "Nalanda",
                "Nalanda",
                "Bihar",
                803110,
                "India",
                58,
                23,
                "ok",
                "ok",
                "rohit",
                "7371857426",
                "kumardiwanhshu00@gmail.com",
                "",
                "this is great hotel",
                38000));
        venues.add( new Venue(
                2,
                1,
                "benq",
                "Nalanda",
                "Nalanda",
                "Bihar",
                803110,
                "India",
                58,
                23,
                "ok",
                "ok",
                "rohit",
                "7371857426",
                "kumardiwanhshu00@gmail.com",
                "",
                "this is great hotel",
                38000));

    }
    public Venue save(Venue venue) {
        venues.add(venue);
        return venue;
    }

    public List<Venue> findAllVenue(){
        return venues;
    }

    public Venue findVenueByID(int venueId) {
        return venues.stream().
                filter(venue -> venueId == venue.getVenueId()).findFirst().
                orElse(null);
    }

    public Venue update(Venue venue) {
        var venueIndex = IntStream.range(0, venues.size())
                .filter(index -> venues.get(index).getVenueId()== venue.getVenueId()).findFirst()
                .orElse(-1);

        if(venueIndex >-1){
            venues.set(venueIndex, venue);
            return venue;
        }
        return null;
    }

    public void delete(int venueId) {
        var event = findVenueByID(venueId);
        if(event!=null){
            venues.remove(event);
        }
    }
}
