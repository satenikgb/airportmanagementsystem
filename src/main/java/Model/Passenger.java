package Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "passenger")

public class Passenger extends Base {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",nullable = false,length = 30)
    private String name;
    @Column(name = "phone",nullable = false,length = 50)
    private String phone;

    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.PERSIST)
    @JoinColumn(name = "id_address",
            foreignKey = @ForeignKey(name = "passenger_address_fk"))
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="pass_in_trip",
    joinColumns={@JoinColumn(name="passenger_id")},
            inverseJoinColumns = {@JoinColumn(name="trip_id")}
    )
    private Set<Trip> trips=new HashSet<>();


    public Passenger(String name, String phone) {

        this.name = name;
        this.phone = phone;
    }

    public Passenger() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}'+'\n';
    }
}
