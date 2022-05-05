package Service;

import org.hibernate.cfg.Configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactorySingleton {

        public static SessionFactory factory;


        private FactorySingleton() {
        }

        public static synchronized SessionFactory getSessionFactory() {

            if (factory == null) {
                factory =  new Configuration().
                        configure("src//main/resources//hibernate.properties").buildSessionFactory();
            }
            return factory;
        }
}
