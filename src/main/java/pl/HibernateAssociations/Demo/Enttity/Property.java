package pl.HibernateAssociations.Demo.Enttity;

import javax.persistence.*;

@Entity
@Table(name = "propery")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProperty")
    private Integer idProperty;
    @Column(name = "city")
    private  String city;
    @Column(name = "room_number")
    private Integer roomNumber;

    public Property(String city, Integer roomNumber) {
        this.city = city;
        this.roomNumber = roomNumber;
    }

    public Integer getIdProperty() {
        return idProperty;
    }

    public void setIdProperty(Integer idProperty) {
        this.idProperty = idProperty;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Property{" +
                "idProperty=" + idProperty +
                ", city='" + city + '\'' +
                ", roomNumber=" + roomNumber +
                '}';
    }
}
