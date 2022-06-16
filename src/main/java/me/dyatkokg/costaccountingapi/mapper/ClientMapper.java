package me.dyatkokg.costaccountingapi.mapper;

import me.dyatkokg.costaccountingapi.dto.ClientDTO;
import me.dyatkokg.costaccountingapi.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "password",ignore = true)
    Client toEntity(ClientDTO clientDTO);
}
