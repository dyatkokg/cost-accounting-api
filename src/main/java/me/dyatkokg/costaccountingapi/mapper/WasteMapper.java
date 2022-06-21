package me.dyatkokg.costaccountingapi.mapper;

import me.dyatkokg.costaccountingapi.dto.WasteDTO;
import me.dyatkokg.costaccountingapi.entity.Waste;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WasteMapper {

    @Mapping(source = "accountId",target = "account.id")
    @Mapping(source = "category",target = "category.name")
    Waste toEntity(WasteDTO dto);

    @Mapping(source = "account.id",target = "accountId")
    @Mapping(source = "category.name",target = "category")
    WasteDTO toDTO(Waste waste);
}
