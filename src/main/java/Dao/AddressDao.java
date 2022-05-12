package Dao;

import Model.Address;

import java.util.Set;

public interface AddressDao {
    void createAddress(Address address);


    Address getAddressById(Address address,int id);

    void update(int id, Address address);


    void deleteById(int id);

    Set<Address> getAll(Address address);
}
