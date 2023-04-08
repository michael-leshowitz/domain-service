package cookbook.domainservice.recipe_service.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CookingAction {
    private Integer id;
    private Appliance appliance;
    private Integer duration_min;
    private String description;
}
