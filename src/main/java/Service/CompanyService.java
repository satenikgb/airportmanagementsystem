package Service;

import Dao.impl.AddressDaoImpl;
import Dao.impl.CompanyDaoImpl;
import Model.Address;
import Model.Company;
import Model.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CompanyService {
    public static void addCompanyData() {


        Company company = new Company();
        CompanyDaoImpl companyDao=new CompanyDaoImpl();
        String[] array;
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\User\\IdeaProjects\\AirportMS\\src" +
                "\\main\\java\\Resources\\companies.txt"))
        ) {
            while (true) {
                try {
                    if ((line = br.readLine()) == null) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                line = line.replace("'", "");
                array = line.split(",");

                company.setCompanyName(array[0]);
                company.setFoundingDate(array[1]);
               companyDao.save(company);



            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
   /* public static   void addCompany(Company company){
        Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(company);
        session.getTransaction().commit();
        session.close();


    }

    */

}
