package bunker.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sales")
public class Sale implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "invoices",
    joinColumns = @JoinColumn(name = "sale_id"), inverseJoinColumns = @JoinColumn(name = "product_id"),
    uniqueConstraints = {@UniqueConstraint(columnNames = {"sale_id", "product_id"})})
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Product> products;

    private String direccion;

    private Date created;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Person person;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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
}
