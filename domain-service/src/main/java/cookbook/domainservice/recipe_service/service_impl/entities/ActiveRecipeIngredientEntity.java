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
public class ActiveRecipeIngredientEntity implements Serializable {

    private Integer step;

    @Id
    @ManyToOne
    @JoinColumn(name="RecipeId", nullable = false)
    private RecipeEntity recipe;

    @Id
    @OneToOne
    @JoinColumn(name="ActiveIngredientId", nullable = false)
    private ActiveIngredientEntity ingredient;

    @OneToOne
    @JoinColumn(name="CookingActionId", nullable = false)
    private CookingActionEntity action;
}
