package pl.HibernateAssociations.Demo.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.HibernateAssociations.Demo.Enttity.Company;
import pl.HibernateAssociations.Demo.Enttity.CompanyDetail;


public class OneToOneApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();
        Company company = new Company("Strefa_kursow",10000);
        CompanyDetail companyDetail = new CompanyDetail("Poland", 150);
        company.setCompanyDetail(companyDetail);
        session.beginTransaction();
        session.save(companyDetail);
        session.save(company);



        session.getTransaction().commit();

        factory.close();

    }

}
