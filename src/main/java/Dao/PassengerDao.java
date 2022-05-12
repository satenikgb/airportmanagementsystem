package Dao;

import Model.Passenger;
import Model.Trip;

import java.util.List;
import java.util.Set;

public interface PassengerDao {
    void getById(Passenger passenger,int Id);

    List<Passenger> getAll(Passenger passenger);

    Set<Passenger> get(int offset, int perPage, String sort);

    void update(Passenger passenger, int Id);

    void delete(int passengerId);

    List<Passenger> getPassengersOfTrip(int tripNumber);

    void registerTrip(Trip trip, Passenger passenger);

    void cancelTrip(int passengerId, int tripNumber);
}
