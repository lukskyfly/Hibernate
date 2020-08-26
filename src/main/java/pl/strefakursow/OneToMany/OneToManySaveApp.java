package pl.strefakursow.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.HibernateAssociations.Demo.Enttity.Company;
import pl.HibernateAssociations.Demo.Enttity.CompanyDetail;
import pl.HibernateAssociations.Demo.Enttity.Property;

public class OneToManySaveApp {
    public static void main(String[] args) {

        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        conf.addAnnotatedClass(Property.class);
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.getCurrentSession();

        String getCompany = "select c from Company c where c.name = 'KGHM'";
        session.beginTransaction();
//        Property property = new Property("Moskwa",125);
//        Property property2 = new Property("Paryz",160);
        Query dupa =session.createQuery(getCompany);

        int idToDelete = 5;
       Property property =  session.get(Property.class,idToDelete);
        session.delete(property);
//        Company company = (Company) dupa.getSingleResult();
//        System.out.println(company);
//      for(Property property : company.getProperties()){
//          if("Warszawa".equals(property.getCity())) {
//              session.delete(property);
//          }
//        }
//        company.addProperty(property);
//        company.addProperty(property2);
//        session.persist(property);
//        session.persist(property2);
        session.getTransaction().commit();
        factory.close();
    }
}
