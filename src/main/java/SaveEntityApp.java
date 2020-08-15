import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.HibernateDemo1.entity.Employee;

public class SaveEntityApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        Employee employee = new Employee();
        employee.setIdEmployee(1);
        employee.setFirstName("Jan");
        employee.setLastName("Kowalski");
        employee.setSalary(10000);

        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        factory.close();


    }

}
