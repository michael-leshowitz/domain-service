package cookbook.domainservice.recipe_service.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActiveRecipeIngredient {
    private ActiveIngredient ingredient;
    private Integer step;
    private CookingAction action;
    private Recipe recipe;
}
