package cookbook.domainservice.recipe_service.service_impl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cookbook.domainservice.recipe_service.api.models.ActiveIngredient;
import cookbook.domainservice.recipe_service.service_impl.entities.ActiveIngredientEntity;

@Mapper
public interface ActiveRecipeIngredientMapper {
    ActiveRecipeIngredientMapper INSTANCE = Mappers.getMapper(ActiveRecipeIngredientMapper.class);

    ActiveIngredient entityToModel(ActiveIngredientEntity activeIngredientEntity);
    ActiveIngredientEntity modelToEntity(ActiveIngredient activeIngredient);
}
