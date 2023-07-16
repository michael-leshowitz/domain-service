package cookbook.domainservice.recipe_service.service_impl.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="UserRatings")
public class UserRatingEntity {
    @Id
    @Column(name="userId")
    private Integer owner;

    @Id
    @ManyToOne
    @JoinColumn(name="RecipeId")
    private RecipeEntity recipe;

    private Double rating;
}
