package Dao;

import Model.Trip;

import java.util.List;
import java.util.Set;

public interface TripDao {
    Trip getById(Trip trip,int Id);

    Set<Trip> getAll(Trip trip);

    Set<Trip> get(int offset, int perPage, String sort);

    void save(Trip trip);

    Trip update(Trip trip, int id);

    void delete(int tripId);

    List<Trip> getTripsFrom(String city);

    List<Trip> getTripsTo(String city);

}
