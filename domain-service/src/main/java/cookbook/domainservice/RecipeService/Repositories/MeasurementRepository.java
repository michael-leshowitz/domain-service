package cookbook.domainservice.RecipeService.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cookbook.domainservice.RecipeService.Entities.Measurement;

@Repository
public interface MeasurementRepository extends CrudRepository<Measurement, Integer>{
    
}
