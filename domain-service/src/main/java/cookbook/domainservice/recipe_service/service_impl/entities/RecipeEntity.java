package cookbook.domainservice.recipe_service.service_impl.entities;

import java.util.Set;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Recipe")
public class RecipeEntity {
    @Id
    @Column(name="idRecipe")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    // TODO: Update to a one-to-one mapping once user services is implemented
    private Integer owner;

    @OneToMany
    @JoinColumn(name="RecipeId", nullable = false)
    private Set<ActiveRecipeIngredientEntity> steps;

    @Formula("(SELECT AVG(ur.rating) FROM UserRatings ur WHERE ur.RecipeId = idRecipe)")
    private Double averageRating;
}
