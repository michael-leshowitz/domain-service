package cookbook.domainservice.ingredient_service.service_impl.mappers;

import org.mapstruct.Mapper;

import cookbook.domainservice.ingredient_service.api.models.Grocery;
import cookbook.domainservice.ingredient_service.service_impl.entities.GroceryEntity;

@Mapper(componentModel = "spring")
public interface GroceryMapper {

    Grocery entityToModel(GroceryEntity groceryEntity);

    GroceryEntity modelToEntity(Grocery grocery);
}
