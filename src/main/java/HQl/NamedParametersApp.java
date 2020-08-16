package HQl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.HibernateDemo1.entity.Employee;

import java.util.List;

public class NamedParametersApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        String empolyeeFirstName = "Steven";
        String empolyeeLastName = "King";
        session.beginTransaction();
//        String queryString = "select e.firstName, e.lastName, e.salary from employee e where e.firstName = '" +
//                empolyeeFirstName + "'and e.lastName='" + empolyeeLastName + "'";

        String namedParametersString = "select e.firstName, e.lastName, e.salary from Employee e where e.firstName =:firstName and e.lastName=:lastName";
        Query namedParametersQuery = session.createQuery(namedParametersString);
        namedParametersQuery.setParameter("firstName", empolyeeFirstName);
        namedParametersQuery.setParameter("lastName",empolyeeLastName);
//        Query query = session.createQuery(queryString);
        List<Object[]> result = namedParametersQuery.getResultList();


        session.getTransaction().commit();
        for (Object[] values : result) {
            System.out.println("Imie : " + values[0] + ", Nazwisko : " + values[1] + ", Wyplata : " + values[2]);

        }
        factory.close();

    }
}
