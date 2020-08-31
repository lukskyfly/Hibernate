package pl.strefakursow;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.HibernateDemo1.entity.Employee;

public class UpdateDetachedEntityApp {
    public static void main(String[] args) {



        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();


        session.beginTransaction();
        Employee employee= session.get(Employee.class,11);
        session.getTransaction().commit();
        System.out.println("Dane Pracownika " + employee);
        employee.setFirstName("Paweł ");
        employee.setLastName("Markiewicz");
        session = factory.getCurrentSession();
        session.beginTransaction();
        session.update(employee);
        session.getTransaction().commit();
        System.out.println(employee + " zaktualizowane dane");
        factory.close();

    }
}
