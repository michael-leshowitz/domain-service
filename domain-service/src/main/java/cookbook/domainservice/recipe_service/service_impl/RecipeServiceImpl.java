package cookbook.domainservice.recipe_service.service_impl;
import java.util.List;
import org.springframework.stereotype.Service;
import cookbook.domainservice.recipe_service.api.RecipeService;
import cookbook.domainservice.recipe_service.api.models.Recipe;
import cookbook.domainservice.recipe_service.service_impl.entities.RecipeEntity;
import cookbook.domainservice.recipe_service.service_impl.entities.projections.RecipeSnippetView;
import cookbook.domainservice.recipe_service.service_impl.mappers.RecipeMapper;
import cookbook.domainservice.recipe_service.service_impl.repositories.RecipeRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    @NonNull private final RecipeRepository recipeRepository;
    @NonNull private final RecipeMapper recipeMapper;

    public List<Recipe> searchRecipesByKeyword(String keyword) {
        return recipeMapper.entityToModel(recipeRepository.fullTextByKeyword(keyword));
    }
    // Mapping from entity to model
    // RecipeMapper.Instance.entityToModle(...)
    public List<Recipe> topNToMRecipes(Integer lowerBound, Integer upperBound) {
        // TODO: Replace with topNToMRecipes        
        List<RecipeSnippetView> sortedRecipeList = recipeRepository.findAllProjectedBy();
        // TODO: Add error handling for case where lowerBound or upperBound are outside range of recipes in database
        List<RecipeSnippetView> sortedRecipeSubList = sortedRecipeList.subList(lowerBound, upperBound);
        return recipeMapper.projectionToModel(sortedRecipeSubList);
    }
}
