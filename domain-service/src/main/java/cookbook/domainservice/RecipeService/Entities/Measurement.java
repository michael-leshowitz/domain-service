package cookbook.domainservice.RecipeService.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Measurement {
    @Id
    @Column(name="idMeasurement")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
}
