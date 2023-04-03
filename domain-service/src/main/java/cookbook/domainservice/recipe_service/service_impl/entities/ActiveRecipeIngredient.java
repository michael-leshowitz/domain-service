package cookbook.domainservice.recipe_service.service_impl.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ActiveRecipeIngredient")
public class ActiveRecipeIngredient implements Serializable {
    // Note: No repository needed for this, Active recipe ingredients don't have value on own

    private Integer step;

    @Id
    @ManyToOne
    @JoinColumn(name="idRecipe", nullable = false)
    private Recipe recipe;

    @Id
    @OneToOne
    private ActiveIngredient ingredient;

    @OneToOne
    private CookingAction action;
}
