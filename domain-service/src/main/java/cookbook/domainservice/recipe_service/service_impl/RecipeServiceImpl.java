package cookbook.domainservice.recipe_service.service_impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import cookbook.domainservice.recipe_service.api.RecipeService;
import cookbook.domainservice.recipe_service.api.models.Recipe;
import cookbook.domainservice.recipe_service.service_impl.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    public List<Recipe> searchRecipesByKeyword(String keyword) {
        List<Recipe> placeholder = new ArrayList<Recipe>();
        return placeholder;
    }
    // Maps go from Entity to domain model 
    // JMapper<Recipe, RecipeEntity> recipeMapper = new JMapper<>(Recipe.class, RecipeEntity.class);
    // public List<Recipe> searchRecipesByKeyword(String keyword) {
    //     return recipeRepository.fullTextByKeyword(keyword).stream()
    //         .map(recipeEntity -> recipeMapper.getDestination(recipeEntity))
    //         .collect(Collectors.toList());
    // }
    
}
