package me.dyatkokg.costaccountingapi.controller;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.costaccountingapi.dto.DateDTO;
import me.dyatkokg.costaccountingapi.dto.ExpenseDTO;
import me.dyatkokg.costaccountingapi.dto.ExpenseSumCategoryDTO;
import me.dyatkokg.costaccountingapi.entity.Expense;
import me.dyatkokg.costaccountingapi.service.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("expense")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService service;

    @PostMapping
    public ResponseEntity<ExpenseDTO> addExpense(@RequestBody @Validated ExpenseDTO expenseDTO) {
        return ResponseEntity.ok(service.addExpense(expenseDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<Expense> getExpenseByID(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(service.getExpense(id));
    }

    //todo:вывод полной статистики клиента за период с группировкой по дате(день, список транзакций, получено за день-списано за день),
    // отдельный контроллер? относится к клиенту
    @GetMapping("all")
    public ResponseEntity<Page<ExpenseDTO>> getAllExpenseByClientsAccount(@RequestParam(value = "size", required = false, defaultValue = "10") int page,
                                                                        @RequestParam(value = "page", required = false, defaultValue = "0") int size,
                                                                        @RequestBody DateDTO viewDTO) {
        return ResponseEntity.ok(service.getAllByClient(page, size, viewDTO));
    }

    @GetMapping("sum")
    public ResponseEntity<ExpenseSumCategoryDTO> getSumExpenseByCategory(@RequestBody ExpenseSumCategoryDTO sumDTO) {
        return ResponseEntity.ok(service.getSumAllExpenseByCategory(sumDTO));
    }
    //todo: сумма по ВСЕМ категориям
}
