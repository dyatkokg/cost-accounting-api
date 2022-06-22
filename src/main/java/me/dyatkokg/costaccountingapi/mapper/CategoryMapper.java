package me.dyatkokg.costaccountingapi.mapper;

import me.dyatkokg.costaccountingapi.dto.CategoryDTO;
import me.dyatkokg.costaccountingapi.entity.ExpenseCategory;
import me.dyatkokg.costaccountingapi.entity.IncomeCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    ExpenseCategory toExpenseEntity(CategoryDTO dto);

    IncomeCategory toIncomeEntity(CategoryDTO dto);

    CategoryDTO toExpenseDTO(ExpenseCategory expenseCategory);

    CategoryDTO toIncomeDTO(IncomeCategory incomeCategory);


}
