package Service;

import Model.PassInTrip;
import Model.Trip;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PassInTripService {
    public static void addPassInTripData(SessionFactory sessionFactory) {
        PassInTrip passInTrip = new PassInTrip();
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

                passInTrip.setTripId(Long.parseLong(array[0]));
                passInTrip.setPassengerId(Long.parseLong(array[1]));
                passInTrip.setDate(array[2]);
                passInTrip.setPlace(array[3]);

               addPassInTrip(passInTrip,sessionFactory);

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

    public static void addPassInTrip(PassInTrip passInTrip, SessionFactory factory) {
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(passInTrip);
        session.getTransaction().commit();
        session.close();


    }
}
