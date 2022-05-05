package Dao.impl;

import Dao.CompanyDao;
import Model.Company;
import Service.FactorySingleton;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Set;

import static Service.FactorySingleton.factory;

public class CompanyDaoImpl implements CompanyDao {
    @Override
    public Company getById(long Id, SessionFactory factory) {
        return null;
    }

    @Override
    public void getAll() {

    }

    @Override
    public Set<Company> get(int offsset, int perPage, String sort) {
        return null;
    }

    @Override
    public void save(Company company) {
        Session session = (Session) factory;
        session.beginTransaction();
        session.save(company);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void update(Company company, long Id) {

    }

    @Override
    public void delete(long companyId) {

    }
}
