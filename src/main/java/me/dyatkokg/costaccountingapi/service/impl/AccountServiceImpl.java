package me.dyatkokg.costaccountingapi.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dyatkokg.costaccountingapi.config.SecurityUtils;
import me.dyatkokg.costaccountingapi.dto.AccountDTO;
import me.dyatkokg.costaccountingapi.dto.AccountTransactionDTO;
import me.dyatkokg.costaccountingapi.dto.DateDTO;
import me.dyatkokg.costaccountingapi.entity.Account;
import me.dyatkokg.costaccountingapi.entity.Client;
import me.dyatkokg.costaccountingapi.exception.AccountNotFoundException;
import me.dyatkokg.costaccountingapi.mapper.AccountMapper;
import me.dyatkokg.costaccountingapi.repository.AccountRepository;
import me.dyatkokg.costaccountingapi.repository.ExpenseRepository;
import me.dyatkokg.costaccountingapi.repository.IncomeRepository;
import me.dyatkokg.costaccountingapi.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final AccountMapper mapper;

    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;


    @Override
    public Account addAccount(AccountDTO account) {
        account.setClient((Client) SecurityUtils.getPrincipal());
        return repository.save(mapper.toEntity(account));
    }

    @Override
    public Account editAccount(UUID id, AccountDTO accountDTO) {
        Account account = mapper.toEntity(accountDTO);
        account.setId(id);
        return repository.save(account);
    }

    @Override
    public Account getAccount(UUID id) {
        return repository.findById(id).orElseThrow(AccountNotFoundException::new);
    }

    @Override
    public void deleteAccount(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<Account> getAll() {
        Client principal = (Client) SecurityUtils.getPrincipal();
        return new ArrayList<>(repository.findAccountByClientId(principal.getId()));
    }

    @Override
    public AccountTransactionDTO getTotalByAccount(UUID uuid, DateDTO dateDTO) {
        AccountTransactionDTO accountTransactionDTO = new AccountTransactionDTO();
        accountTransactionDTO.setAccountId(uuid);
        accountTransactionDTO.setTotalExpense(expenseRepository.getSumExpense(uuid, dateDTO.getStartDate(), dateDTO.getEndDate()));
        accountTransactionDTO.setTotalIncome(incomeRepository.getSumIncome(uuid, dateDTO.getStartDate(), dateDTO.getEndDate()));
        return accountTransactionDTO;
    }


}
