package Dao;

import Model.Company;
import org.hibernate.SessionFactory;

import java.util.Set;

public interface CompanyDao {
    Company getById(long Id, SessionFactory factory);

    void getAll();

    Set<Company> get(int offsset, int perPage, String sort);

    void save(Company company) ;

    void update(Company company, long Id) ;

    void delete(long companyId) ;
}
