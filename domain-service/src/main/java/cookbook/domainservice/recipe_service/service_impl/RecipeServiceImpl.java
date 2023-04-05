package cookbook.domainservice.recipe_service.service_impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cookbook.domainservice.recipe_service.api.RecipeService;
import cookbook.domainservice.recipe_service.api.models.Recipe;
import com.googlecode.jmapper.JMapper;
import cookbook.domainservice.recipe_service.service_impl.entities.RecipeEntity;
import cookbook.domainservice.recipe_service.service_impl.repositories.RecipeRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    // Maps go from Entity to domain model 
    JMapper<Recipe, RecipeEntity> recipeMapper = new JMapper<>(Recipe.class, RecipeEntity.class);
    public List<Recipe> searchRecipesByKeyword(String keyword) {
        return recipeRepository.fullTextByKeyword(keyword).stream()
            .map(recipeEntity -> recipeMapper.getDestination(recipeEntity))
            .collect(Collectors.toList());
    }
    
}
