package cookbook.domainservice.recipe_service.service_impl.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import cookbook.domainservice.recipe_service.api.models.Recipe;
import cookbook.domainservice.recipe_service.service_impl.entities.RecipeEntity;

@Mapper
public interface RecipeMapper {
    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);
    
    @Mapping(target = "steps", source = "activeIngredient")
    Recipe entityToModel(RecipeEntity recipeEntity);

    @Mapping(target = "activeIngredient", source = "steps")
    RecipeEntity modelToEntity(Recipe recipe);
}
