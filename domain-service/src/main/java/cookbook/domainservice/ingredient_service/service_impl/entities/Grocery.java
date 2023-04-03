package cookbook.domainservice.ingredient_service.service_impl.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Grocery")
public class Grocery {
    @Id
    @Column(name = "idGrocery")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    // TODO: Figure out how to store these JSON properties
}
