package pl.strefakursow.HibernateDemo1.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyApp {
    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        Employee employee1 = new Employee();

        employee1.setFirstName("Krzysztof");
        employee1.setLastName("Nowak");
        employee1.setSalary(10000);

        Employee employee2 = new Employee();
        employee2.setFirstName("Janina");
        employee2.setLastName("Kowalska");
        employee2.setSalary(10000);

        Employee employee3 = new Employee();

        employee3.setFirstName("Andrzej");
        employee3.setLastName("Sienkiewicz");
        employee3.setSalary(10000);



        session.beginTransaction();
        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        session.getTransaction().commit();
        factory.close();


    }
}
