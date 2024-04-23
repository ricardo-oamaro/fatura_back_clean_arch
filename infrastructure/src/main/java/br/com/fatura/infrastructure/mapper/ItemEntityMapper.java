package br.com.fatura.infrastructure.mapper;

import br.com.fatura.core.domain.Item;
import br.com.fatura.infrastructure.dto.request.CreateItemRequest;
import br.com.fatura.infrastructure.entity.ItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemEntityMapper {

    ItemEntity toItemEntity(Item item);

    @Mapping(target = "id", ignore = true)
    Item toItem(CreateItemRequest request);

    @Mapping(target = "id", ignore = true)
    Item toItem(ItemEntity itemEntity);
}
