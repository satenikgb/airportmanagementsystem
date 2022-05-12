package Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trip")
public class Trip extends Base{
    @Id

    private int id;
    @Column(name = "plane",length = 30)
    private String plane;
    @Column(name = "town_from",nullable = false)
    private String townFrom;
    @Column(name = "town_to",nullable = false)
    private String townTo;
    @Column(name = "time_out",nullable = false)
    private String timeOut;
    @Column(name = "time_in",nullable = false)
    private String timeIn;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", foreignKey = @ForeignKey(name = "company_trip_fk"))
    private Company company;
    @ManyToMany(mappedBy = "trips")
    private Set<Passenger> passengers=new HashSet<>();

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Trip(){

    }

    public Trip(String plane, String townFrom,
                String townTo, String timeOut, String timeIn) {

        this.plane = plane;
        this.townFrom = townFrom;
        this.townTo = townTo;
        this.timeOut = timeOut;
        this.timeIn = timeIn;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public String getPlane() {
        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    public String getTownFrom() {
        return townFrom;
    }

    public void setTownFrom(String townFrom) {
        this.townFrom = townFrom;
    }

    public String getTownTo() {
        return townTo;
    }

    public void setTownTo(String townTo) {
        this.townTo = townTo;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "plane='" + plane + '\'' +
                ", townFrom='" + townFrom + '\'' +
                ", townTo='" + townTo + '\'' +
                ", timeOut='" + timeOut + '\'' +
                ", timeIn='" + timeIn + '\'' +
                ", company=" + company +
                ", passengers=" + passengers +
                '}';
    }
}
