package cookbook.domainservice.recipe_service.service_impl.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cookbook.domainservice.recipe_service.service_impl.entities.RecipeEntity;
import cookbook.domainservice.recipe_service.service_impl.entities.projections.RecipeCardView;

@Repository
public interface RecipeRepository extends CrudRepository<RecipeEntity, Integer> {
    
    @Query(value = "SELECT * FROM Recipe WHERE MATCH(name) AGAINST (?1)",
    nativeQuery = true)
    public List<RecipeEntity> fullTextByKeyword(String keyword);

    // TODO: Replace with findByOrderBy... to get top rated
    // public List<RecipeEntity> findAll();

    public List<RecipeCardView> findAllProjectedBy();
}
