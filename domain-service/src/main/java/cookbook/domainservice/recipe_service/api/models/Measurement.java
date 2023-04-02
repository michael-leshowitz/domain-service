package cookbook.domainservice.recipe_service.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Measurement {
    private Integer id;
    private String name;
}
