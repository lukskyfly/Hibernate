package pl.strefakursow;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.HibernateDemo1.entity.*;

import java.util.List;

public class ManyToManyDeleteApp {
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

        int id =233;
        int idToDelete = 4;
         session.beginTransaction();
        Training training = session.get(Training.class,idToDelete);
        session.delete(training);


        session.getTransaction().commit();
        //Zamkniecie obiektu SessionFactory
        factory.close();


    }
}
