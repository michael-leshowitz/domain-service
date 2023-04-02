package cookbook.domainservice.ingredient_service.api.models;

import java.util.ArrayList;

import cookbook.domainservice.tag_management_service.api.models.Tag;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Grocery {
    
    private Integer id;

    private String name;

    private ArrayList<Tag> tags;
}
