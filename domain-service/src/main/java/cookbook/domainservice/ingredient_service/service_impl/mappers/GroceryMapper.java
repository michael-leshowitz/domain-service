package cookbook.domainservice.ingredient_service.service_impl.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cookbook.domainservice.ingredient_service.api.models.Grocery;
import cookbook.domainservice.ingredient_service.service_impl.entities.GroceryEntity;

@Mapper
public interface GroceryMapper {
    GroceryMapper INSTANCE = Mappers.getMapper(GroceryMapper.class);

    Grocery entityToModel(GroceryEntity groceryEntity);

    GroceryEntity modelToEntity(Grocery grocery);
}
