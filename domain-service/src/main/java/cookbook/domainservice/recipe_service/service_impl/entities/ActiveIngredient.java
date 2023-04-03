package cookbook.domainservice.recipe_service.service_impl.entities;

import cookbook.domainservice.ingredient_service.service_impl.entities.Grocery;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    private Integer quantity;
    
    @ManyToOne
    @JoinColumn(name = "idGrocery")
    private Grocery grocery;
    
    @ManyToOne
    @JoinColumn(name = "idMeasurement")
    private Measurement measurement;
}
