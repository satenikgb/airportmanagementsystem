package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
public class Company extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "company_name",length = 30,nullable = false)
    private String companyName;
    @Column(name = "founding_date", length = 40,nullable = false)
    private String foundingDate;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    private List<Trip> trips = new ArrayList<>();

    public Company(String companyName, String foundingDate) {
        this.companyName=companyName;
        this.foundingDate=foundingDate;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", foundingDate='" + foundingDate  +
                '}'+'\n';
    }

    public Company(String companyName, String foundingDate, int id) {
        this.companyName = companyName;
        this.foundingDate = foundingDate;
        this.id = id;
    }

    public Company(){

    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFoundingDate() {
        return foundingDate;
    }

    public void setFoundingDate(String foundingDate) {
        this.foundingDate = foundingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
