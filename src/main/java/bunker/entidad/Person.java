package bunker.entidad;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "persons")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String type;

    private String address;

    private Long phone;

    private String email;

    private Date created;
}
