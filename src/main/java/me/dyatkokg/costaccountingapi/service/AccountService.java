package me.dyatkokg.costaccountingapi.service;

import me.dyatkokg.costaccountingapi.dto.AccountDTO;
import me.dyatkokg.costaccountingapi.entity.Account;
import org.springframework.http.ResponseEntity;

public interface AccountService {
    Account addAccount(AccountDTO account);
}
