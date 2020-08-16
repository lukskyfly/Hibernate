package HQl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.HibernateDemo1.entity.Employee;

import java.util.List;

public class WhereApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        String where = "from Employee where firstName = 'Tadeusz'";
        String where2 = "from Employee where salary>12000";
        String where3 = "from Employee where salary <3000 or salary>13000";
        String where4 = "from Employee where salary is null";
        String where5 = "from Employee where lastName in ('Grazda','Errazuriz', 'Wiśniewski')";


        Query query = session.createQuery(where5);
        List<Employee> list = query.getResultList();
        session.getTransaction().commit();
        for (Employee employee:list) {
            System.out.println(employee);

        }
        factory.close();

    }
}
