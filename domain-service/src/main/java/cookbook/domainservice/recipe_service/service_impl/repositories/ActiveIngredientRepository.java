package cookbook.domainservice.recipe_service.service_impl.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cookbook.domainservice.recipe_service.service_impl.entities.ActiveIngredient;

@Repository
public interface ActiveIngredientRepository extends CrudRepository<ActiveIngredient, Integer> {
    // Note: <Enitiy, PrimaryKey>
    // TODO: Remove this repository. Active Ingredients don't have meaning
}
