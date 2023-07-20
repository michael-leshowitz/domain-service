package cookbook.domainservice.recipe_service.service_impl.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import cookbook.domainservice.recipe_service.api.models.Recipe;
import cookbook.domainservice.recipe_service.service_impl.entities.RecipeEntity;
import cookbook.domainservice.recipe_service.service_impl.entities.projections.RecipeCardView;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    
    Recipe entityToModel(RecipeEntity recipeEntity);
    List<Recipe> entityToModel(List<RecipeEntity> recipeEntity);

    Recipe projectionToModel(RecipeCardView recipeSnippetView);
    List<Recipe> projectionToModel(List<RecipeCardView> recipeSnippetViews);

    RecipeEntity modelToEntity(Recipe recipe);
    List<RecipeEntity> modelToEntity(List<Recipe> recipe);

}
