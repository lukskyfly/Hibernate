package pl.strefakursow.HibernateDemo1.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateManageEntityApp {

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Employee employee= session.get(Employee.class,11);
        employee.setFirstName("Tadeusz");
        session.getTransaction().commit();
        employee.setLastName("Nowak");
        System.out.println(employee + " zaktualizowane dane");
        factory.close();


    }
}
