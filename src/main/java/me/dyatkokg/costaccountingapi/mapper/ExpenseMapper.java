package me.dyatkokg.costaccountingapi.mapper;

import me.dyatkokg.costaccountingapi.dto.ExpenseDTO;
import me.dyatkokg.costaccountingapi.entity.Expense;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {

    @Mapping(source = "accountId", target = "account.id")
    @Mapping(source = "category", target = "category.name")
    Expense toEntity(ExpenseDTO dto);

    @Mapping(source = "account.id", target = "accountId")
    @Mapping(source = "category.name", target = "category")
    ExpenseDTO toDTO(Expense expense);
}
