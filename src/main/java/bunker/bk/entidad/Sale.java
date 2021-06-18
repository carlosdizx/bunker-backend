package bunker.bk.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
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
}
