package cookbook.domainservice.recipe_service.service_impl.mappers;

import org.mapstruct.Mapper;

import cookbook.domainservice.recipe_service.api.models.ActiveIngredient;
import cookbook.domainservice.recipe_service.service_impl.entities.ActiveIngredientEntity;

@Mapper(componentModel = "spring")
public interface ActiveRecipeIngredientMapper {

    ActiveIngredient entityToModel(ActiveIngredientEntity activeIngredientEntity);
    ActiveIngredientEntity modelToEntity(ActiveIngredient activeIngredient);
}
