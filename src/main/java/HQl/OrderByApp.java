package HQl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.HibernateDemo1.entity.Employee;

import java.util.List;

public class OrderByApp {

    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        String orderBy = "select e.firstName, e.lastName from Employee e order by e.firstName";
        String orderBy2 = "select e.firstName, e.lastName from Employee e order by e.lastName desc";
        String orderBy3 = "select e.firstName, e.lastName, e.salary  from Employee e order by salary desc";

        Query query = session.createQuery(orderBy3);
        List<Object[]> result = query.getResultList();


        session.getTransaction().commit();
        for (Object[] values : result) {
            System.out.println("Imie : " + values[0] + ", Nazwisko : " + values[1] + ", Wyplata : " + values[2]);

        }
        factory.close();

    }
}
