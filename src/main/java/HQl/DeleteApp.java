package HQl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.HibernateDemo1.entity.Employee;

public class DeleteApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Employee.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();


        int idEmployee = 225;

        session.beginTransaction();

        String delete = "delete Employee e  where e.idEmployee=:idEmployee";
        Query query = session.createQuery(delete);

        query.setParameter("idEmployee",idEmployee);
        query.executeUpdate();

        session.getTransaction().commit();
        factory.close();

    }
}
