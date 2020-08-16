package HQl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.HibernateDemo1.entity.Employee;

import java.util.List;

public class SelectApp {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        String select = "select firstName, lastName from Employee";
        String select2 = "select e.firstName, e.lastName from Employee as e";
        String select3 = "select e.firstName, e.lastName from Employee  e";

        Query query = session.createQuery(select3);
        List<Object[]> result = query.getResultList();


        session.getTransaction().commit();
        for (Object[] values : result) {
            System.out.println("Imie : " + values[0] + ", Nazwisko : " + values[1]);

        }
        factory.close();
    }

}
