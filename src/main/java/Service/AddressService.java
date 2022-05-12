package Service;

import Dao.impl.AddressDaoImpl;
import Model.Address;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import Model.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AddressService {


    public static Set<Address> addAddressData() {
        Address address = new Address();
        AddressDaoImpl addressDao = new AddressDaoImpl();

        Set<Address> addressSet = null;
        String[] array;
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/Resources/passengers.txt"))
        ) {
            addressSet = new HashSet<>();
            while (true) {
                try {
                    if ((line = br.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                line = line.replace("'", "");
                array = line.split(",");
                address = new Address();

                address.setCountry(array[2]);
                address.setCity(array[3]);
                addressSet.add(address);
                addressDao.createAddress(address);

            }
            try {
                System.out.println();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return addressSet;

    }


}







