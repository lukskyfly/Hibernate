package pl.strefakursow;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.HibernateDemo1.entity.*;

import java.util.List;

public class ManyToManyGetApp {
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
        int id2 =234;
        session.beginTransaction();


        String getTraining = "from Training";
        Query query = session.createQuery(getTraining);
        List<Training> resultList = query.getResultList();
        for (Training tr: resultList) {
            System.out.println("\n" + tr);
            for (Employee em: tr.getEmployees()) {
                System.out.println("\n" +em);
            }
            
        }
//        Training training = new Training("Java training");
//
//       Employee employee = session.get(Employee.class,233);
//       Employee employee2 = session.get(Employee.class,234);
//
//        training.addEmployee(employee);
//        training.addEmployee(employee2);
//        session.persist(training);

//        Training training = session.get(Training.class,id);
//        System.out.println(training);
//        for (Employee em : training.getEmployees()) {
//            System.out.println(em);
//
//        }

        session.getTransaction().commit();
        //Zamkniecie obiektu SessionFactory
        factory.close();


    }
}
