package bunker.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sales")
public class Sale implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "invoices",
    joinColumns = @JoinColumn(name = "sale_id"), inverseJoinColumns = @JoinColumn(name = "product_id"),
    uniqueConstraints = {@UniqueConstraint(columnNames = {"sale_id", "product_id"})})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Product> products;
    */

    private String direccion;

    @CreationTimestamp
    private Date created;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Person person;

    public Sale(){}

    public Sale(String direccion, Person person) {
        this.direccion = direccion;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                ", created=" + created +
                ", person=" + person +
                '}';
    }
}
