package cookbook.domainservice.recipe_service.service_impl.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

// No need for repository - meaningless on own

@Entity
@Data
@Table(name = "CookingAction")
public class CookingActionEntity {
    @Id
    @Column(name = "idCookingAction")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer duration_min;
    private String description;

    @ManyToOne
    @JoinColumn(name = "appliance")
    private ApplianceEntity appliance;
}
