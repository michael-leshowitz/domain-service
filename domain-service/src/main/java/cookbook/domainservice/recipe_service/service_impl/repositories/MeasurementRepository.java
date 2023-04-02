package cookbook.domainservice.recipe_service.service_impl.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cookbook.domainservice.recipe_service.service_impl.entities.Measurement;

@Repository
public interface MeasurementRepository extends CrudRepository<Measurement, Integer>{
    
}
