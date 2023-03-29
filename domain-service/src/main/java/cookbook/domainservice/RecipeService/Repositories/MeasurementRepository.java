package cookbook.domainservice.RecipeService.Repositories;

import org.springframework.data.repository.CrudRepository;

import cookbook.domainservice.RecipeService.Entities.Measurement;

public interface MeasurementRepository extends CrudRepository<Measurement, Integer>{
    
}
