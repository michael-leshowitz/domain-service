package cookbook.domainservice.recipe_service.service_impl.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ActiveIngredient")
public class ActiveIngredient {
    @Id
    @Column(name = "idActiveIngredient")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer groceryId;
    private Integer quantity;
    private Integer measurementId;
}
