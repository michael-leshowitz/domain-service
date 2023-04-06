package cookbook.domainservice.tag_management_service.service_impl.mappers;

import org.mapstruct.Mapper;

import cookbook.domainservice.tag_management_service.api.models.Tag;
import cookbook.domainservice.tag_management_service.service_impl.entities.TagEntity;

@Mapper
public interface TagMapper {
   
    Tag entityToModel(TagEntity tagEntity);

    TagEntity modelToEntity(Tag tag);
}
