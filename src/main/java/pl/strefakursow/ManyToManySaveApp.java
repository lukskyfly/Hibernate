package pl.strefakursow;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.HibernateDemo1.entity.*;

public class ManyToManySaveApp {
    public static void main(String[] args) {

        //  Stworzenie obiektu Configuration
        Configuration conf = new Configuration();
        //Wczytanie pliku konfiguracujnego
        conf.configure("hibernate.cfg.xml");
        //Wczytanie adnotacji
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        conf.addAnnotatedClass(Property.class);
        conf.addAnnotatedClass(Department.class);
        conf.addAnnotatedClass(Employee.class);
        conf.addAnnotatedClass(Training.class);

        //Stworzenie obiekty SessionFactory
        SessionFactory factory = conf.buildSessionFactory();
        //Pobranie sesji
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        Training training = new Training("sales training");
        Training training2 = new Training("karate  training");

        Employee employee = new Employee("Johny","Deep",16000);
        Employee employee2 = new Employee("Miley","Cyrus",16000);
        Employee employee3 = new Employee("Lukasz","Grazda",25000);
        Employee employee4 = new Employee("Laura","Kowalska",11000);

        training2.addEmployee(employee3);
        training2.addEmployee(employee4);
        session.persist(training2);


        session.getTransaction().commit();
        //Zamkniecie obiektu SessionFactory
        factory.close();


    }
}
