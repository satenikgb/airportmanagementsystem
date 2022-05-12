package Dao.impl;

import Dao.CompanyDao;
import Model.Company;
import Connection.FactorySingleton;
import Transaction.CRUD;
import Transaction.TransactionWrapper;
import org.hibernate.Session;

import java.util.List;


import javax.persistence.Query;
import java.util.Set;



public class CompanyDaoImpl implements CompanyDao {


    @Override
    public void getById(Company company,int Id) {
        /*
        Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        Company company = null;
        company = session.get(Company.class, Id);

        session.getTransaction().commit();
        session.close();
        return company;

         */
        TransactionWrapper.WrapTransaction(company,CRUD.GETBYID,Id);
    }

    @Override
    public void getAll(Company company) {

       /* Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("From Company ");
        List<Company> c=query.getResultList();
                                                           ,mmmmm                          mm
        for(Company company : c){
            System.out.println("List of Company::"+company.getCompanyName()+","+
                    company.getFoundingDate());
        }

        */
        TransactionWrapper.WrapTransaction(company,CRUD.GETALL,0);


    }

    @Override
    public Set<Company> get(int offsset, int perPage, String sort) {
        return null;
    }

    @Override
    public void save(Company company) {
       TransactionWrapper.WrapTransaction(company, CRUD.SAVE,0);

    }

    @Override
    public void update(Company company, int Id) {
        Company c=new Company();

      /*  Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        c = session.get(Company.class, Id);
        c.setCompanyName(company.getCompanyName());
        c.setFoundingDate(company.getFoundingDate());
        session.merge(c);
        session.getTransaction().commit();
        session.close();

       */
        TransactionWrapper.WrapTransaction(company,CRUD.UPDATE,0);
    }

    @Override
    public void delete(int companyId) {

        /*

        Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        company = session.get(Company.class, companyId);
        session.delete(company);
        session.getTransaction().commit();
        session.close();

       */
        TransactionWrapper.WrapTransaction(null,CRUD.DELETE, companyId);
    }
}
