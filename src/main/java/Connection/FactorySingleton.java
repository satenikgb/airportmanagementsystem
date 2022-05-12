package Connection;

import Model.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Configuration;

public class FactorySingleton {
    private static SessionFactory  sessionFactory;


    private FactorySingleton(){

    }
    public static SessionFactory  getSessionFactory(){
        if(sessionFactory==null){
            Configuration configuration = new Configuration();

            configuration.addAnnotatedClass(Address.class);
            configuration.addAnnotatedClass(Company.class);
            configuration.addAnnotatedClass(Passenger.class);
            configuration.addAnnotatedClass(Trip.class);
            configuration.addAnnotatedClass(PassInTrip.class);

            sessionFactory=configuration.buildSessionFactory();


        }
        return sessionFactory;
    }

}

