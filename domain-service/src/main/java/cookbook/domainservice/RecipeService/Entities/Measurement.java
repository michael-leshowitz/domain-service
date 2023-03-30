package cookbook.domainservice.RecipeService.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Measurement")
public class Measurement {
    @Id
    @Column(name="idMeasurement")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
}
