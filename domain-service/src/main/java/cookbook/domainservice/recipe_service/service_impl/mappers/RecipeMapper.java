package cookbook.domainservice.recipe_service.service_impl.mappers;

import org.mapstruct.Mapper;

import cookbook.domainservice.recipe_service.api.models.Recipe;
import cookbook.domainservice.recipe_service.service_impl.entities.RecipeEntity;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    
    Recipe entityToModel(RecipeEntity recipeEntity);

    RecipeEntity modelToEntity(Recipe recipe);
}
