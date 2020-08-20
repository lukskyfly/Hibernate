package pl.HibernateAssociations.Demo.Enttity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company")
    private Integer idCompany;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private Integer value;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_company_detail")
    private CompanyDetail companyDetail;


    public Company(CompanyDetail companyDetail) {
        this.companyDetail = companyDetail;
    }

    public CompanyDetail getCompanyDetail() {
        return companyDetail;
    }

    public void setCompanyDetail(CompanyDetail companyDetail) {
        this.companyDetail = companyDetail;
    }


    public Company(){

    }

    public Company(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Company{" +
                "idCompany=" + idCompany +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }


}
