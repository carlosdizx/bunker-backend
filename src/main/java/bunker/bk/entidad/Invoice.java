package bunker.bk.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "invoices")
public class Invoice implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int amoung;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmoung() {
        return amoung;
    }

    public void setAmoung(int amoung) {
        this.amoung = amoung;
    }
}
