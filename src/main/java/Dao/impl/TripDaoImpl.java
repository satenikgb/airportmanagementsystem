package Dao.impl;

import Dao.TripDao;
import Model.Trip;
import Connection.FactorySingleton;
import Transaction.CRUD;
import Transaction.TransactionWrapper;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;
import java.util.Set;

public class TripDaoImpl implements TripDao {

    @Override
    public Trip getById(Trip trip,int Id) {
      /*  Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        Trip trip = null;
        trip = session.get(Trip.class, Id);

        session.getTransaction().commit();
        session.close();
        return trip;

       */
        TransactionWrapper.WrapTransaction(trip, CRUD.GETBYID,Id);
        return null;

    }

    @Override
    public Set<Trip> getAll(Trip trip) {
      /*  Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("From Trip ");
        List<Trip> c=query.getResultList();

        for(Trip trip : c){
            System.out.println("List of Trip::"+trip.getPlane()+","+
                    trip.getCompany()+","+
                    trip.getTownTo()+","+
                    trip.getTownFrom()+","+
                    trip.getTimeIn()+","+
                    trip.getTimeOut()+","+
                    trip.getPassengers());

        }

       */
        TransactionWrapper.WrapTransaction(trip,CRUD.GETALL,0);
        return null;
    }

    @Override
    public Set<Trip> get(int offset, int perPage, String sort) {
        return null;
    }

    @Override
    public void save(Trip trip) {
       /* Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(trip);
        session.getTransaction().commit();

        session.close();

        */
        TransactionWrapper.WrapTransaction(trip,CRUD.SAVE,0);
    }

    @Override
    public Trip update(Trip trip, int id) {
       Trip trip1=new Trip();

        Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        trip = session.get(Trip.class,id);
        trip1.setCompany(trip.getCompany());
        trip1.setPassengers(trip.getPassengers());
        trip1.setPlane(trip.getPlane());
        trip1.setTimeIn(trip.getTimeIn());
        trip1.setTimeOut(trip.getTimeOut());
        trip1.setTownTo(trip.getTownTo());
        trip1.setTownFrom(trip.getTownFrom());
        session.merge(trip1);
        session.getTransaction().commit();
        session.close();


        return trip1;
    }

    @Override
    public void delete(int tripId) {
       /* Trip trip=new Trip();

        Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        trip = session.get(Trip.class, tripId);
        session.delete(trip);
        session.getTransaction().commit();
        session.close();

        */
        TransactionWrapper.WrapTransaction(null,CRUD.DELETE,tripId);

    }

    @Override
    public List<Trip> getTripsFrom(String city) {
        Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("From Trip where townFrom=:city");
        query.setParameter("city",city);

        List<Trip> c=query.getResultList();

        for(Trip trip : c){
            System.out.println("List of Trip::"+trip.getPassengers()+","+
                    trip.getCompany());
        }
        return null;

    }

    @Override
    public List<Trip> getTripsTo(String city) {
        Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("From Trip where townTo=:city");
        query.setParameter("city",city);

        List<Trip> c=query.getResultList();

        for(Trip trip : c){
            System.out.println("List of Trip::"+trip.getPassengers()+","+
                    trip.getCompany());
        }
        return null;
    }
}
