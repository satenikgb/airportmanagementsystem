package Transaction;

import Connection.FactorySingleton;
import Model.Base;
import org.hibernate.Session;

import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;

public class TransactionWrapper {

    public static void WrapTransaction(Base model, CRUD query, int id) {


       Session session = FactorySingleton.getSessionFactory().openSession();
        session.beginTransaction();
        switch (query) {
            case SAVE:
                session.save(model);
                break;
                case UPDATE:
                break;
            case DELETE:
                model = session.get(model.getClass(), id);
                session.delete(model);
                break;
            case GETALL:
                Query query1 = session.createQuery("From " + model.getClass().getName());
                List<Base> list = query1.getResultList();
                System.out.println(list);
                break;

            case GETBYID:
                model = session.get(model.getClass(), id);
                System.out.println(model);
                break;


        }

        session.getTransaction().commit();
        session.close();


    }




   /* public static Base setField(Base base, String fieldName, Base base1) {
        System.out.println("svdg");
        Field field;
        try {
            field = base.getClass().getDeclaredField(fieldName);
            System.out.println("D");
        } catch (NoSuchFieldException e) {
            field = null;
        }
        Class superClass = base.getClass().getSuperclass();
        while (field == null && superClass != null) {
            try {
                field = superClass.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                superClass = superClass.getSuperclass();
            }
        }
        if (field == null) {
            return null;
        }
        field.setAccessible(true);
        try {
            field.set(base, base1);
            System.out.println(base1);
            return base1;
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    */


}
