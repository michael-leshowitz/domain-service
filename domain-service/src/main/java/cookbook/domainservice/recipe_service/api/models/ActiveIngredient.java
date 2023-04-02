package cookbook.domainservice.recipe_service.api.models;

import cookbook.domainservice.ingredient_service.api.models.Grocery;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActiveIngredient {
    private Integer id;
    private Grocery grocery;
    private Integer quantity;
    private Measurement measurement;
}
