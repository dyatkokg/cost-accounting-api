package me.dyatkokg.costaccountingapi.service.impl;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.costaccountingapi.config.SecurityUtils;
import me.dyatkokg.costaccountingapi.dto.DateDTO;
import me.dyatkokg.costaccountingapi.dto.ExpenseDTO;
import me.dyatkokg.costaccountingapi.dto.ExpenseSumCategoryDTO;
import me.dyatkokg.costaccountingapi.dto.ExpenseSumDTO;
import me.dyatkokg.costaccountingapi.entity.Account;
import me.dyatkokg.costaccountingapi.entity.Client;
import me.dyatkokg.costaccountingapi.entity.Expense;
import me.dyatkokg.costaccountingapi.exception.ExpenseNotFoundException;
import me.dyatkokg.costaccountingapi.mapper.AccountMapper;
import me.dyatkokg.costaccountingapi.mapper.ExpenseMapper;
import me.dyatkokg.costaccountingapi.repository.ExpenseCategoryRepository;
import me.dyatkokg.costaccountingapi.repository.ExpenseRepository;
import me.dyatkokg.costaccountingapi.service.AccountService;
import me.dyatkokg.costaccountingapi.service.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository repository;

    private final ExpenseMapper mapper;

    private final AccountService accountService;

    private final AccountMapper accountMapper;

    private final ExpenseCategoryRepository expenseCategoryRepository;

    @Override
    public ExpenseDTO addExpense(ExpenseDTO expenseDTO) {
        Expense expense = mapper.toEntity(expenseDTO);
        expense.setCategory(expenseCategoryRepository.findCategoryByName(expenseDTO.getCategory()));
        Account account = accountService.getAccount(expenseDTO.getAccountId());
        account.setBalance(account.getBalance().subtract(expenseDTO.getAmountSpent()));
        accountService.editAccount(account.getId(), accountMapper.toDTO(account));
        return mapper.toDTO(repository.save(expense));
    }

    @Override
    public Expense getExpense(UUID id) {
        return repository.findById(id).orElseThrow(ExpenseNotFoundException::new);
    }

    @Override
    public Page<ExpenseDTO> getAllByClient(int page, int size, DateDTO viewDTO) {
        Client principal = (Client) SecurityUtils.getPrincipal();
        Pageable pageable = PageRequest.of(size, page, Sort.Direction.DESC, "date");
        return repository.findWasteByAccount_ClientIdAndDateBetween(principal.getId(), pageable,
                viewDTO.getStartDate(), viewDTO.getEndDate()).map(mapper::toDTO);
    }

    @Override
    public ExpenseSumCategoryDTO getSumAllExpenseByCategory(ExpenseSumCategoryDTO wasteSumCategoryDTO) {
        List<Expense> allByCategory_nameAndDateBetween = repository.findAllByCategory_NameAndDateBetween(wasteSumCategoryDTO.getCategory(),
                wasteSumCategoryDTO.getStartDate(), wasteSumCategoryDTO.getEndDate());
        BigDecimal sum = allByCategory_nameAndDateBetween.stream()
                .map(Expense::getAmountSpent)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        wasteSumCategoryDTO.setSumExpense(sum);
        return wasteSumCategoryDTO;
    }

    @Override
    public ExpenseSumDTO getSumAllExpense(DateDTO dateDTO) {
        ExpenseSumDTO expenseSumDTO =new ExpenseSumDTO();
        expenseSumDTO.setTotalExpense(repository.getTotalExpense(dateDTO.getStartDate(), dateDTO.getEndDate()));
        return expenseSumDTO;
    }


}
