package cookbook.domainservice.recipe_service.service_impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import cookbook.domainservice.recipe_service.api.RecipeService;
import cookbook.domainservice.recipe_service.api.models.Recipe;
import cookbook.domainservice.recipe_service.service_impl.repositories.RecipeRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Builder;

@Service
@Builder
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    @NonNull private final RecipeRepository recipeRepository;

    public List<Recipe> searchRecipesByKeyword(String keyword) {
        List<Recipe> placeholder = new ArrayList<Recipe>();
        return placeholder;
    }
    // Mapping from entity to model
    // RecipeMapper.Instance.entityToModle(...)
}
