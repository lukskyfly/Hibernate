import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.HibernateDemo1.entity.Employee;

import java.util.List;

public class GetAllEntitisApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Employee> resoultList = session.createQuery("from Employee").getResultList();
        for (Employee employee : resoultList) {
            System.out.println(employee);
        }
        session.getTransaction().commit();
        factory.close();


    }


}
