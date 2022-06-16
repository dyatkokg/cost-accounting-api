package me.dyatkokg.costaccountingapi.controller;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.costaccountingapi.dto.AccountDTO;
import me.dyatkokg.costaccountingapi.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    //todo: не забыть дабавить идентификацию пользователя
    @PutMapping("add")
    public ResponseEntity<?> addAccount(@RequestBody @Validated AccountDTO account){
        return ResponseEntity.ok(service.addAccount(account));
    }

}
