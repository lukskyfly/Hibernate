package HQl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.HibernateDemo1.entity.Employee;

import java.util.List;

public class UpdateUp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();


        int idEmployee = 225;
        int salary = 16000;
        session.beginTransaction();

        String update = "update Employee e set e.salary =:salary where e.idEmployee=:idEmployee";
        Query query = session.createQuery(update);
        query.setParameter("salary",salary);
        query.setParameter("idEmployee",idEmployee);
        query.executeUpdate();

        session.getTransaction().commit();
        factory.close();

    }

}
