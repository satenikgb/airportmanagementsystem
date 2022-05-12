package Service;

import Dao.impl.TripDaoImpl;
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
    public static void addTripData() {
        TripDaoImpl tripDao=new TripDaoImpl();
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

                Company company=new Company();
                company.setId(Integer.parseInt(array[1]));
                trip.setId(Integer.parseInt(array[0]));
                trip.setCompany(company);
                trip.setPlane(array[2]);
                trip.setTownTo(array[3]);
                trip.setTownFrom(array[4]);
                trip.setTimeIn(array[5]);
                trip.setTimeOut(array[6]);



                tripDao.save(trip);

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


}
