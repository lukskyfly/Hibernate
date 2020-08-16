import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.HibernateDemo1.entity.Employee;

public class DeleteEntityApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Employee employee= session.get(Employee.class,6);
        session.delete(employee);

        session.getTransaction().commit();

        factory.close();

    }

}
