package me.dyatkokg.costaccountingapi.exception.handler;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dyatkokg.costaccountingapi.exception.AccountNotFoundException;
import me.dyatkokg.costaccountingapi.exception.CategoryAlreadyExistException;
import me.dyatkokg.costaccountingapi.exception.IncomeNotFoundException;
import me.dyatkokg.costaccountingapi.exception.ExpenseNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;

@ControllerAdvice
@Slf4j
@NoArgsConstructor
public class ApiExceptionHandler {
    @ExceptionHandler({AccountNotFoundException.class, ExpenseNotFoundException.class,
            UsernameNotFoundException.class, IncomeNotFoundException.class, CategoryAlreadyExistException.class})
    public ResponseEntity<?> handleException(RuntimeException e) {
        log.info("{}", e.getMessage());
        return ResponseEntity.badRequest().body(Collections.singletonMap("exception", e.getMessage()));
    }
}
