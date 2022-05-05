package Service;

import Model.Address;
import Model.Company;
import Model.Passenger;
import Model.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class TripService {
    public static void addTripData(SessionFactory sessionFactory) {
        Trip trip = new Trip();
        String[] array;
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/Resources/trip1.txt"))
        ) {
            while (true) {
                try {
                    if ((line = br.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                line = line.replace("'", "");
                array = line.split(",");

                trip.setTripNumber(Long.parseLong(array[0]));


                trip.setPlane(array[2]);
                trip.setTownTo(array[3]);
                trip.setTownFrom(array[4]);
                trip.setTimeIn(array[5]);
                trip.setTimeOut(array[6]);



                addTrip(trip, sessionFactory);

            }
            try {
                System.out.println();
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addTrip(Trip trip, SessionFactory factory) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(trip);
        session.getTransaction().commit();
        session.close();


    }
}
