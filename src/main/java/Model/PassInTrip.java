package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pass_in_trip")
public class PassInTrip implements Serializable{
    @Id
    @Column(name = "passenger_id", nullable = false)
    private Long passengerId;

    @Id
    @Column(name = "trip_id", nullable = false)
    private Long tripId;

    public PassInTrip(){
    }


    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "place", nullable = false, length = 50)
    private String place;



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }




}
