package HQl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.HibernateAssociations.Demo.Enttity.Company;
import pl.HibernateAssociations.Demo.Enttity.CompanyDetail;
import pl.HibernateAssociations.Demo.Enttity.Department;
import pl.HibernateAssociations.Demo.Enttity.Property;

import java.util.List;

public class OneTOManyUniSaveApp {
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
        //Stworzenie obiekty SessionFactory
        SessionFactory factory = conf.buildSessionFactory();
        //Pobranie sesji
        Session session = factory.getCurrentSession();

        int id =49;
        session.beginTransaction();
        Company company = session.get(Company.class,id);
        System.out.println(company);
        Department department = new Department("Sales");
        Department department2 = new Department("Production");
        Department department3 = new Department("Hr");
        company.addDepartment(department);
        company.addDepartment(department2);
        company.addDepartment(department3);

        session.persist(company);

        session.getTransaction().commit();




        //Zamkniecie obiektu SessionFactory
        factory.close();
    }
}
