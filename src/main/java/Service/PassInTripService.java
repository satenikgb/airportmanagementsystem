package Service;

import Connection.FactorySingleton;
import Model.PassInTrip;
import org.hibernate.Session;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PassInTripService {
    public static void addPassInTripData() {
        PassInTrip passInTrip = new PassInTrip();
        String[] array;
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/Resources/passintrip.txt"))
        ) {
            while (true) {
                try {
                    if ((line = br.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                line = line.replace("'", "");
                array = line.split(",");

               passInTrip.setTripId(Integer.parseInt((array[0])));
                passInTrip.setPassengerId(Integer.parseInt((array[1])));
                passInTrip.setDate(array[2]);
                passInTrip.setPlace(array[3]);

               addPassInTrip(passInTrip);

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

    public static void addPassInTrip(PassInTrip passInTrip) {
        Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(passInTrip);
        session.getTransaction().commit();
        session.close();


    }
}
