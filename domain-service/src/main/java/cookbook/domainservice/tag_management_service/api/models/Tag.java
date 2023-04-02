package cookbook.domainservice.tag_management_service.api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Tag {
    private Integer id;

    private String title;
}
