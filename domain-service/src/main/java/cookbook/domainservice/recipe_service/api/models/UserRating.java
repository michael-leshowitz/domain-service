package cookbook.domainservice.recipe_service.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRating {
    private Integer owner;
    private Recipe recipe;
    private Double rating;
}
