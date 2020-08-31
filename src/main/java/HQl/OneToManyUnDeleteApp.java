package HQl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.HibernateDemo1.entity.Company;
import pl.strefakursow.HibernateDemo1.entity.CompanyDetail;
import pl.strefakursow.HibernateDemo1.entity.Department;
import pl.strefakursow.HibernateDemo1.entity.Property;

public class OneToManyUnDeleteApp {
    public static void main(String[] args) {
        //  Stworzenie obiektu Configuration
        Configuration conf = new Configuration();
        //Wczytanie pliku konfiguracujnego
        conf.configure("hibernate.cfg.xml");
        //Wczytanie adnotacji
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);
        conf.addAnnotatedClass(Property.class);
        conf.addAnnotatedClass(Department.class);
        //Stworzenie obiekty SessionFactory
        SessionFactory factory = conf.buildSessionFactory();
        //Pobranie sesji
        Session session = factory.getCurrentSession();

        int id =4;
        int idCompany = 49;
        String departNameTODelete="Hr";
        int idHql = 5;

        String delete = "delete Department d where d.idDepartment=:idDepartment";

        session.beginTransaction();
//        Department department= session.get(Department.class,4);
//        session.delete(department);
//        Company company = session.get(Company.class,idCompany);
//        for (Department department : company.getDepartments()) {
//            if(department.getName().equals(departNameTODelete)){
//                company.getDepartments().remove(department);
//                session.delete(department);
//            }
//
//        }
        Query query = session.createQuery(delete);
        query.setParameter("idDepartment",idHql);
        int deletedRows = query.executeUpdate();

        System.out.println("ilosc usnietych wierszy: " + deletedRows);

        session.getTransaction().commit();
        //Zamkniecie obiektu SessionFactory
        factory.close();
    }
}
