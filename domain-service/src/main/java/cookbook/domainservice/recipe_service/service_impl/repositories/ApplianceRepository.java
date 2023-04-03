package cookbook.domainservice.recipe_service.service_impl.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cookbook.domainservice.recipe_service.service_impl.entities.Appliance;



@Repository
public interface ApplianceRepository extends CrudRepository<Appliance, Integer> {
    
}
