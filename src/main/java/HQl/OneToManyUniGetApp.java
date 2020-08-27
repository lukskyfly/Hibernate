package HQl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.HibernateAssociations.Demo.Enttity.Company;
import pl.HibernateAssociations.Demo.Enttity.CompanyDetail;
import pl.HibernateAssociations.Demo.Enttity.Department;
import pl.HibernateAssociations.Demo.Enttity.Property;

import java.util.Set;

public class OneToManyUniGetApp {
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
//        Company company = session.get(Company.class,id);
//        System.out.println(company);
//
//        Set<Department> departments = company.getDepartments();
//
//        for (Department department: departments) {
//            System.out.println(department);
//
//        }

        Department department = session.get(Department.class,6);
        System.out.println(department);

        session.getTransaction().commit();




        //Zamkniecie obiektu SessionFactory
        factory.close();
    }
}
