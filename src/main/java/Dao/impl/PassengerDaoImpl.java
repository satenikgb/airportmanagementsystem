package Dao.impl;

import Dao.PassengerDao;
import Model.Passenger;
import Model.Trip;
import Connection.FactorySingleton;
import Transaction.CRUD;
import Transaction.TransactionWrapper;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PassengerDaoImpl implements PassengerDao {



    @Override
    public void getById(Passenger passenger,int Id) {
     /*   Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        Passenger passenger = null;
        passenger = session.get(Passenger.class, Id);

        session.getTransaction().commit();
        session.close();
        return passenger;

      */
        TransactionWrapper.WrapTransaction(passenger, CRUD.GETBYID,Id);

    }

    @Override
    public List<Passenger> getAll(Passenger passenger) {
      /*  Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("From Passenger ");
        List<Passenger> c=query.getResultList();

        for(Passenger passenger : c){
            System.out.println("List of Passenger::"+passenger.getName()+","+
                    passenger.getPhone()+passenger.getAddress());
        }

       */
        TransactionWrapper.WrapTransaction(passenger,CRUD.GETALL,0);
        return null;



    }

    @Override
    public Set<Passenger> get(int offset, int perPage, String sort) {
        return null;
    }

    @Override
    public void update(Passenger passenger, int Id) {
        Passenger passenger1=new Passenger();

        Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        passenger1 = session.get(Passenger.class, Id);
        passenger1.setName(passenger.getName());
        passenger1.setPhone((passenger.getPhone()));
        session.merge(passenger1);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void delete(int passengerId) {
       /* Passenger passenger=new Passenger();

        Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        passenger = session.get(Passenger.class, passengerId);
        session.delete(passenger);
        session.getTransaction().commit();
        session.close();

        */
        TransactionWrapper.WrapTransaction(null,CRUD.DELETE,passengerId);


    }

    @Override
    public List<Passenger> getPassengersOfTrip(int tripNumber) {
        Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("select a from Trip b join b.passengers a where b.id= :id");
        query.setParameter("id",tripNumber);
        List<Passenger> c=query.getResultList();

        for(Passenger passenger : c){
            System.out.println("List of Passenger::"+passenger.getName());

        }


        return null;
    }

    @Override
    public void registerTrip(Trip trip, Passenger passenger) {
        Set<Passenger> passengers=new HashSet<>();
        passengers.add(passenger);
        trip.setPassengers(passengers);
        Session session=FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(trip);
        session.getTransaction().commit();
        session.close();


    }

    @Override
    public void cancelTrip(int passengerId, int tripNumber) {
        Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "delete  from Trip where  id=:tripNumber";

        session.createQuery(hql).
                setInteger("id",tripNumber).
                executeUpdate();

        session.getTransaction().commit();
        session.close();



    }
}
