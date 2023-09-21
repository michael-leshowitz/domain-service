package cookbook.domainservice.recipe_service.service_impl;
import java.util.List;
import org.springframework.stereotype.Service;
import cookbook.domainservice.recipe_service.api.RecipeService;
import cookbook.domainservice.recipe_service.api.models.Recipe;
import cookbook.domainservice.recipe_service.service_impl.entities.projections.RecipeCardView;
import cookbook.domainservice.recipe_service.service_impl.entities.projections.RecipeSearchResultView;
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
        List<RecipeSearchResultView> projections = recipeRepository.fullTextRecipeSearchByKeyword(keyword);
        // projections.forEach(result -> System.out.println(result.getId()));
        return recipeMapper.recipeSearchProjectionToModel(projections);
    }
    // Mapping from entity to model
    // RecipeMapper.Instance.entityToModle(...)
    public List<Recipe> topNToMRecipes(Integer lowerBound, Integer upperBound) {
        // TODO: Replace with topNToMRecipes        
        if (lowerBound >= upperBound) {
            throw new IndexOutOfBoundsException();
        }
        List<RecipeCardView> sortedRecipeList = recipeRepository.findAllProjectedBy();        
        List<RecipeCardView> sortedRecipeSubList;
        try {
            sortedRecipeSubList = sortedRecipeList.subList(lowerBound, upperBound);
        } catch (IndexOutOfBoundsException e) {
            sortedRecipeSubList = sortedRecipeList.subList(Math.max(lowerBound,0), Math.min(upperBound,sortedRecipeList.size()));   
        }
        return recipeMapper.recipeCardProjectionToModel(sortedRecipeSubList);
    }
}
