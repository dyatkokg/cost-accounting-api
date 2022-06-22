package me.dyatkokg.costaccountingapi.controller;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.costaccountingapi.dto.AccountDTO;
import me.dyatkokg.costaccountingapi.entity.Account;
import me.dyatkokg.costaccountingapi.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping
    public ResponseEntity<Account> addAccount(@RequestBody @Validated AccountDTO account) {
        return ResponseEntity.ok(service.addAccount(account));
    }

    @PutMapping("{id}")
    public ResponseEntity<Account> editAccount(@PathVariable("id") UUID id, @RequestBody AccountDTO accountDTO) {
        return ResponseEntity.ok(service.editAccount(id, accountDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<Account> getAccount(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(service.getAccount(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable("id") UUID id) {
        service.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Account>> getAllByClient() {
        return ResponseEntity.ok(service.getAll());
    }

    //todo: получение транзакций по конкретному счету, вывод за конкретный период:всего поступило,
    // всего потрачено-без детализации


}
