package cookbook.domainservice.recipe_service.service_impl.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cookbook.domainservice.recipe_service.service_impl.entities.RecipeEntity;
import cookbook.domainservice.recipe_service.service_impl.entities.projections.RecipeCardView;
import cookbook.domainservice.recipe_service.service_impl.entities.projections.RecipeSearchResultView;

@Repository
public interface RecipeRepository extends CrudRepository<RecipeEntity, Integer> {
    
    @Query(value = "SELECT r1_0.idRecipe as id, r1_0.name,r1_0.description, r1_0.owner,(SELECT AVG(ur.rating) "
    +"FROM UserRatings ur WHERE ur.RecipeId = r1_0.idRecipe) as averageRating FROM Recipe r1_0"+
    " WHERE MATCH(name) AGAINST (?1)",
    nativeQuery = true)
    public List<RecipeSearchResultView> fullTextRecipeSearchByKeyword(String keyword);

    // TODO: Replace with findByOrderBy... to get top rated
    // public List<RecipeEntity> findAll();

    public List<RecipeCardView> findAllProjectedBy();
}
