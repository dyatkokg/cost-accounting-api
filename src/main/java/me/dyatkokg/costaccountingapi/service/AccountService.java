package me.dyatkokg.costaccountingapi.service;

import me.dyatkokg.costaccountingapi.dto.AccountDTO;
import me.dyatkokg.costaccountingapi.entity.Account;

import java.util.UUID;

public interface AccountService {
    Account addAccount(AccountDTO account);

    Account editAccount(UUID id, AccountDTO accountDTO);

    Account getAccount(UUID id);

    void deleteAccount(UUID id);
}
