import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.HibernateAssociations.Demo.Enttity.Company;
import pl.HibernateAssociations.Demo.Enttity.CompanyDetail;

public class BiDirectionalApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
//        Company company = new Company("PZU", 50000000);
//        CompanyDetail detail = new CompanyDetail("POLAND",15000);
//        company.setCompanyDetail(detail);

        session.beginTransaction();
        CompanyDetail detail = session.get(CompanyDetail.class,26);
        session.remove(detail);
//        session.persist(company);
//        session.persist(detail);
        session.getTransaction().commit();

        System.out.println(detail.getCompany());

        factory.close();


    }
}
