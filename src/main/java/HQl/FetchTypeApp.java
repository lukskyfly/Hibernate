package HQl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.HibernateAssociations.Demo.Enttity.Company;
import pl.HibernateAssociations.Demo.Enttity.CompanyDetail;
import pl.HibernateAssociations.Demo.Enttity.Property;

import java.util.List;

public class FetchTypeApp {
    public static void main(String[] args) {
        //  Stworzenie obiektu Configuration
        Configuration conf = new Configuration();
        //Wczytanie pliku konfiguracujnego
        conf.configure("hibernate.cfg.xml");
        //Wczytanie adnotacji
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        conf.addAnnotatedClass(Property.class);
        //Stworzenie obiekty SessionFactory
        SessionFactory factory = conf.buildSessionFactory();
        //Pobranie sesji
        Session session = factory.getCurrentSession();

        int id = 46;
        session.beginTransaction();
        System.out.println("Pobieranie obiektu company");
        Company company = session.get(Company.class,id);
        System.out.println("Pobrano obiekt company");
        System.out.println(company);
        System.out.println("Nieruchomosci :");
        for (Property property : company.getProperties()){
            System.out.println(property);
        }

        session.getTransaction().commit();
        //Zamkniecie obiektu SessionFactory
        factory.close();
    }
}
