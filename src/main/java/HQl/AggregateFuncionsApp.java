package HQl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.HibernateDemo1.entity.Employee;

public class AggregateFuncionsApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        String avg = "select round(avg(e.salary),2) from Employee e";
        String sum  = "select round(sum(e.salary),2) from Employee e";
        String count = "select round(count(e.salary),2) from Employee e";
        String min = "select round(min(e.salary),2) from Employee e";
        String max = "select round(max(e.salary),2) from Employee e";


        Query query = session.createQuery(count);
        Long resoult = (Long) query.getSingleResult();

        session.getTransaction().commit();
        System.out.println("wynik " + resoult);

        factory.close();


    }
}
