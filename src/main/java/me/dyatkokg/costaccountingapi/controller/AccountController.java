package me.dyatkokg.costaccountingapi.controller;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.costaccountingapi.dto.AccountDTO;
import me.dyatkokg.costaccountingapi.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    //todo: не забыть дабавить идентификацию пользователя
    @PostMapping
    public ResponseEntity<?> addAccount(@RequestBody @Validated AccountDTO account){
        return ResponseEntity.ok(service.addAccount(account));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> editAccount(@PathVariable("id")UUID id,@RequestBody AccountDTO accountDTO){
        return ResponseEntity.ok(service.editAccount(id,accountDTO));
    }



}
