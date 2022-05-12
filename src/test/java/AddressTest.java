import Dao.impl.AddressDaoImpl;
import Model.Address;
import Transaction.CRUD;
import Transaction.TransactionWrapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddressTest {
    AddressDaoImpl addressDao = new AddressDaoImpl();

    @Test
    void saveTest() {
        Address address = new Address("aaa", "sss");

        TransactionWrapper.WrapTransaction(address, CRUD.SAVE, 0);

        Integer id1 = AddressDaoImpl.getAddressId(address);
        Assertions.assertEquals(address.getCountry(), "aaa");
        Assertions.assertEquals(address.getCity(), "sss");
        Assertions.assertTrue(id1 > 0);

    }

    @Test
    void deleteTest() {
        Address address = new Address("aaa", "sss");

        TransactionWrapper.WrapTransaction(address, CRUD.SAVE, 0);

        Integer id1 = AddressDaoImpl.getAddressId(address);
        TransactionWrapper.WrapTransaction(address, CRUD.DELETE, id1);
        Assertions.assertEquals(address.getCountry(), "aaa");
        Assertions.assertEquals(address.getCity(), "sss");

    }
}
