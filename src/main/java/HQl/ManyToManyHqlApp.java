package HQl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.HibernateDemo1.entity.*;

import java.util.List;

public class ManyToManyHqlApp {

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

        int minEmployeeNumber = 6;
        String getTraining = "select t from Training t where size(t.employees)>= : minEmployeeNumber";
        String course = "javascript";
        String getEmployee = "select e from Employee e join e.trainings t where t.name =:course ";
        int trainingNumber = 1;
        int maxSalary = 12000;
        String getEmployee2 = "select e from Employee e where size(e.trainings) = :trainingNumber and e.salary < : maxSalary";

        session.beginTransaction();

        Query dupa = session.createQuery(getEmployee2);
//        dupa.setParameter("minEmployeeNumber", minEmployeeNumber);
        dupa.setParameter("trainingNumber",trainingNumber);
        dupa.setParameter("maxSalary",maxSalary);
        List<Employee> resultList = dupa.getResultList();
//        for (Training tr: resultList) {
//            System.out.println(tr);
//
//        }
        for (Employee employee: resultList) {
            System.out.println(employee);
        }


        session.getTransaction().commit();
        //Zamkniecie obiektu SessionFactory
        factory.close();


    }
}
