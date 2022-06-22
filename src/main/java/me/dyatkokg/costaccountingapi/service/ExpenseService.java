package me.dyatkokg.costaccountingapi.service;

import me.dyatkokg.costaccountingapi.dto.DateDTO;
import me.dyatkokg.costaccountingapi.dto.ExpenseDTO;
import me.dyatkokg.costaccountingapi.dto.ExpenseSumCategoryDTO;
import me.dyatkokg.costaccountingapi.entity.Expense;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface ExpenseService {
    ExpenseDTO addExpense(ExpenseDTO expenseDTO);

    Expense getExpense(UUID id);

    Page<ExpenseDTO> getAllByClient(int page, int size, DateDTO viewDTO);

    ExpenseSumCategoryDTO getSumAllExpenseByCategory(ExpenseSumCategoryDTO wasteSumCategoryDTO);
}
