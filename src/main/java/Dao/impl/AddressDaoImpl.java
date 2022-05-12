package Dao.impl;

import Dao.AddressDao;
import Model.Address;
import Connection.FactorySingleton;

import Transaction.CRUD;
import Transaction.TransactionWrapper;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;
import java.util.Set;

public class AddressDaoImpl implements AddressDao {

    @Override
    public void createAddress(Address address) {
       /* Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(address);
        session.getTransaction().commit();
        session.close();


      //  SessionFunctions.SS(address,"SAVE ");

        */
        TransactionWrapper.WrapTransaction(address, CRUD.SAVE,0);

    }

    @Override
    public Address getAddressById(Address address,int id) {
       /* Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        Address address = null;
        address = session.get(Address.class, id);

        session.getTransaction().commit();
        session.close();
        return address;

        */
        TransactionWrapper.WrapTransaction(address,CRUD.GETBYID,id);
        return null;
    }

    @Override
    public void update(int id, Address address) {
      /*  Address address1=new Address();

        Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        address1 = session.get(Address.class, id);
        address1.setCountry(address.getCountry());
        address1.setCity(address.getCountry());
        session.merge(address1);
        session.getTransaction().commit();
        session.close();

       */





    }

    @Override
    public void deleteById(int id) {
      /*  Address address=new Address();

        Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        address = session.get(Address.class, id);
        session.delete(address);
        session.getTransaction().commit();
        session.close();

       */
        TransactionWrapper.WrapTransaction(null,CRUD.DELETE,id);

    }

    @Override
    public Set<Address> getAll(Address address) {
      /*  Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("From Address ");
        List<Address> c=query.getResultList();

        for(Address address : c){
            System.out.println("List of Address::"+address.getCountry()+","+
                    address.getCity());
        }

       */
        TransactionWrapper.WrapTransaction(address,CRUD.GETALL,0);
        return null;
    }
    public static int getAddressId(Address address){
        Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        Integer id=(Integer) session.save(address);
        session.getTransaction().commit();
        session.close();
        return id;


    }

}
