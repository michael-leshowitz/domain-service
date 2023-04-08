package cookbook.domainservice.tag_management_service.service_impl.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tags")
public class TagEntity {
    @Id
    @Column(name = "idTag")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    // TODO: Does this need a recipe/grocery element?
}
