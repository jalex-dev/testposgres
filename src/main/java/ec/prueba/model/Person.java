package ec.prueba.model;

import java.util.List;
import javax.persistence.*;
import javax.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.mutiny.Uni;
import lombok.*;

@Data
@Entity
public class Person extends PanacheEntity {
    /*
    id, dni, name, lastname, age, country
     */

    public String dni;
    public String name;
    public String lastname;
    public Integer age;
    public String country;


}
