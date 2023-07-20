package cookbook.domainservice.recipe_service.service_impl.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import cookbook.domainservice.recipe_service.api.models.Recipe;
import cookbook.domainservice.recipe_service.service_impl.entities.RecipeEntity;
import cookbook.domainservice.recipe_service.service_impl.entities.projections.RecipeCardView;
import cookbook.domainservice.recipe_service.service_impl.entities.projections.RecipeSearchResultView;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    
    Recipe entityToModel(RecipeEntity recipeEntity);
    List<Recipe> entityToModel(List<RecipeEntity> recipeEntity);

    Recipe recipeCardProjectionToModel(RecipeCardView recipeSnippetView);
    List<Recipe> recipeCardProjectionToModel(List<RecipeCardView> recipeSnippetViews);

    Recipe recipeSearchProjectionToModel(RecipeSearchResultView recipeSnippetView);
    List<Recipe> recipeSearchProjectionToModel(List<RecipeSearchResultView> recipeSnippetViews);

    RecipeEntity modelToEntity(Recipe recipe);
    List<RecipeEntity> modelToEntity(List<Recipe> recipe);

}
