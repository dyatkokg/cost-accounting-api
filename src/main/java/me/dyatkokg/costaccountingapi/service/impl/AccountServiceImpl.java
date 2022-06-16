package me.dyatkokg.costaccountingapi.service.impl;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.costaccountingapi.dto.AccountDTO;
import me.dyatkokg.costaccountingapi.entity.Account;
import me.dyatkokg.costaccountingapi.mapper.AccountMapper;
import me.dyatkokg.costaccountingapi.repository.AccountRepository;
import me.dyatkokg.costaccountingapi.service.AccountService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final AccountMapper mapper;
    @Override
    public Account addAccount(AccountDTO account) {
        return repository.save(mapper.toEntity(account));
    }


}
