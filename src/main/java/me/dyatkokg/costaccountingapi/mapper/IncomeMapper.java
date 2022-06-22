package me.dyatkokg.costaccountingapi.mapper;

import me.dyatkokg.costaccountingapi.dto.IncomeDTO;
import me.dyatkokg.costaccountingapi.entity.Income;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IncomeMapper {

    @Mapping(source = "accountId",target = "account.id")
    Income toEntity(IncomeDTO dto);

    @Mapping(source = "account.id",target = "accountId")
    IncomeDTO toDTO(Income income);
}
