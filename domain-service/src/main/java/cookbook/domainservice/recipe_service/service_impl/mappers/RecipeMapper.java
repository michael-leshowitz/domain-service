package cookbook.domainservice.recipe_service.service_impl.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cookbook.domainservice.recipe_service.api.models.Recipe;
import cookbook.domainservice.recipe_service.service_impl.entities.RecipeEntity;

@Mapper
public interface RecipeMapper {
    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);
    
    Recipe entityToModel(RecipeEntity recipeEntity);

    RecipeEntity modelToEntity(Recipe recipe);
}
