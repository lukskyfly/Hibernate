package HQl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.HibernateDemo1.entity.Company;
import pl.strefakursow.HibernateDemo1.entity.CompanyDetail;
import pl.strefakursow.HibernateDemo1.entity.Property;

import java.util.List;

public class OneToManeHqlApp {
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

        String getCompany = "select c.name from Property p join p.company c where p.city = 'Sevilla'";
        String getCompany2 = "select c.name from Property p join p.company c join c.companyDetail cd where p.city = 'Barcelona' and cd.residence = 'Switzerland'";
        String getCompany3 = "select c.name from Company c  where size(c.properties)>4";
        session.beginTransaction();
        Query dupa = session.createQuery(getCompany3);
        List <String> resultList=dupa.getResultList();

        session.getTransaction().commit();
        for (String resul: resultList) {
            System.out.println(resul);

        }

        //Zamkniecie obiektu SessionFactory
        factory.close();
    }
}
