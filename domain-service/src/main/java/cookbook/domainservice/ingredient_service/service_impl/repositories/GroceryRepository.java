package cookbook.domainservice.ingredient_service.service_impl.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cookbook.domainservice.ingredient_service.service_impl.entities.Grocery;

@Repository
public interface GroceryRepository extends CrudRepository<Grocery, Integer> {
    
}
