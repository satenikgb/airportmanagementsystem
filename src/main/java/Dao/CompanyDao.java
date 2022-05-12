package Dao;

import Model.Company;
import org.hibernate.SessionFactory;
import org.hibernate.mapping.List;

import java.util.Set;

public interface CompanyDao {
    void getById(Company company,int Id);

   void getAll(Company company) ;


    Set<Company> get(int offsset, int perPage, String sort);

    void save(Company company) ;

    void update(Company company, int Id) ;

    void delete(int companyId) ;
}
