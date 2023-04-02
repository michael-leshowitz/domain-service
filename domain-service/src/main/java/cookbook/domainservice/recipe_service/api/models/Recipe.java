package cookbook.domainservice.recipe_service.api.models;

import java.util.ArrayList;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Recipe {
    private Integer id;
    private String name;
    // TODO: Implement User services
    // private User owner;
    private ArrayList<ActiveRecipeIngredient> steps;
}
