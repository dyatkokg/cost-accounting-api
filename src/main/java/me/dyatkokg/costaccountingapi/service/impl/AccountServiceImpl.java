package me.dyatkokg.costaccountingapi.service.impl;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.costaccountingapi.dto.AccountDTO;
import me.dyatkokg.costaccountingapi.entity.Account;
import me.dyatkokg.costaccountingapi.mapper.AccountMapper;
import me.dyatkokg.costaccountingapi.repository.AccountRepository;
import me.dyatkokg.costaccountingapi.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final AccountMapper mapper;
    @Override
    public Account addAccount(AccountDTO account) {
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
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteAccount(UUID id) {
        repository.deleteById(id);
    }


}