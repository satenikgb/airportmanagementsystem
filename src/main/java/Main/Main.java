package Main;

//import java.lang.module.Configuration;

import Dao.impl.CompanyDaoImpl;
import Dao.impl.PassengerDaoImpl;
import Dao.impl.TripDaoImpl;
import Model.*;
import Service.*;
import Transaction.TransactionWrapper;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Main {
    long compute(){
        return 10;
    }

    public static  void main(String[] args) {




            Address address = new Address("Brazil","So Gabriel");



      PassengerService.addPassengerData();
       CompanyService.addCompanyData();

       TripService.addTripData();
      //  PassInTripService.addPassInTripData();
      //  CompanyDaoImpl cp=new CompanyDaoImpl();
      //  System.out.println(cp.getById(5));
      //  cp.update(new Company("Armavia","111111"),1);
       // cp.getAll();
       // PassengerDaoImpl psg=new PassengerDaoImpl();
     //  System.out.println(psg.getById(1));
       // psg.getAll();
      //  psg.getPassengersOfTrip(1181);
      // TripDaoImpl tp=new TripDaoImpl();
        //tp.getAll();
      // tp.getTripsFrom("Paris");
     //  Trip trip=new Trip("Boing111","Erevan","Moscow","111111","222222");
     //  Passenger passenger=new Passenger("Satenik","444444");
     //  psg.registerTrip(trip,passenger);
     //  psg.cancelTrip(1,1100);
        CompanyDaoImpl companyDao=new CompanyDaoImpl();
        PassengerDaoImpl passengerDao=new PassengerDaoImpl();
        passengerDao.getById(new Passenger(),4);
       // passengerDao.getAll(new Passenger());
      //  companyDao.delete(1);
       // companyDao.update(new Company("Saten","5451"),1);
     //  companyDao.getAll(new Company());
       // companyDao.getById(new Company(),5);
        Address address1=new Address("qqqqqq","qqqqqqqqq");
       // TransactionWrapper.setField(address,address.getCountry(), address1);






    }
}


