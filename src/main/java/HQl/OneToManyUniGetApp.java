package HQl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.HibernateDemo1.entity.Company;
import pl.strefakursow.HibernateDemo1.entity.CompanyDetail;
import pl.strefakursow.HibernateDemo1.entity.Department;
import pl.strefakursow.HibernateDemo1.entity.Property;

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
