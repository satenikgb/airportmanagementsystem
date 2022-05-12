package Service;

import Connection.FactorySingleton;
import Model.Address;
import Model.Passenger;
import org.hibernate.Session;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class PassengerService {
    public static void addPassengerData() {
        Set<Address> addressSet1=AddressService.addAddressData();
        Passenger passenger = new Passenger();
        String[] array;
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src//main//java/Resources//passengers.txt"))
        ) {
            while (true) {
                try {
                    if ((line = br.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                line = line.replace("'", "");
                array = line.split(",");

                passenger.setName(array[0]);
                passenger.setPhone(array[1]);
                Address address=new Address();
                address.setCountry(array[2]);
                address.setCity(array[3]);
                for(Address address1:addressSet1){
                    if(address1.equals(address)){
                        passenger.setAddress(address1);
                        addPassenger(passenger);

                        break;
                    }
                }


            }
            try{
                System.out.println();
                        br.close();
            }
         catch (IOException e) {
            throw new RuntimeException(e);
        }

    } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static  void addPassenger(Passenger passenger){
        Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(passenger);
        session.getTransaction().commit();
        session.close();


    }
}
