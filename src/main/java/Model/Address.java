package Model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="Address")

public class Address {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return country.equals(address.country) && city.equals(address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(name="country", length = 30)
    private String country;
    @Column(name="city", length = 30)
    private String city;

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }



    @OneToMany(mappedBy = "address",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Passenger> passengers=new HashSet<>();


    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Address() {

    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }




    public Address(String country, String city) {
        this.country = country;
        this.city = city;

    }
}
