package cookbook.domainservice.recipe_service.service_impl.repositories;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cookbook.domainservice.recipe_service.service_impl.entities.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    
    @Query(value = "SELECT * FROM Recipe WHERE "
        + "MATCH(name) "
        + "AGAINST (?1)")
    public List<Recipe> fullTextByKeyword(String keyword);
}
