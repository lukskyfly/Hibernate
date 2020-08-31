package HQl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.HibernateDemo1.entity.Company;
import pl.strefakursow.HibernateDemo1.entity.CompanyDetail;

import java.util.List;

public class OneToOneHqlApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        String select = "select c from Company c";
        String where = "select c from Company c join c.companyDetail cd where cd.residence = 'Italy'";
        String sum = "select sum(c.value) from Company c join c.companyDetail cd where cd.residence = 'Poland'";
        String orderBy = "select c.name from CompanyDetail cd join cd.company c where cd.employeeNumber > 35000";
        session.beginTransaction();
        Query query = session.createQuery(orderBy);
        //List<Company>  resultList = query.getResultList();
//        Long resoult = (Long) query.getSingleResult();
       List<String>  resultList = query.getResultList();

        session.getTransaction().commit();

//        System.out.println("Wartosc wszystkich firm w Polsce " + resoult);
//       for (Company c: resultList) {
//            System.out.println(c+ ", " + c.getCompanyDetail());
//
//        }
        for (String c: resultList) {
            System.out.println(c);

        }
        factory.close();


    }

}
