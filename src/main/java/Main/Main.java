package Main;

//import java.lang.module.Configuration;

import Dao.impl.CompanyDaoImpl;
import Model.*;
import Service.*;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
        Address address = new Address();

        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Passenger.class);
        configuration.addAnnotatedClass(Trip.class);
        configuration.addAnnotatedClass(PassInTrip.class);
        SessionFactory sessionFactory =configuration.buildSessionFactory();
        PassengerService.addPassengerData(sessionFactory);
        CompanyService.addCompanyData(sessionFactory);

        TripService.addTripData(sessionFactory);
        PassInTripService.addPassInTripData(sessionFactory);
        CompanyDaoImpl cp = new CompanyDaoImpl();
        System.out.println(cp.getById(5, sessionFactory));
        Session session=sessionFactory.openSession();



    }
}


