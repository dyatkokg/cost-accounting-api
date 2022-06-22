package me.dyatkokg.costaccountingapi.controller;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.costaccountingapi.dto.IncomeDTO;
import me.dyatkokg.costaccountingapi.dto.DateDTO;
import me.dyatkokg.costaccountingapi.entity.Income;
import me.dyatkokg.costaccountingapi.service.IncomeService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("income")
@RequiredArgsConstructor
public class IncomeController {

    private final IncomeService service;

    @PostMapping
    public ResponseEntity<Income> addWaste(@RequestBody @Validated IncomeDTO incomeDTO) {
        return ResponseEntity.ok(service.addIncome(incomeDTO));
    }

    @GetMapping("{id}")
    public ResponseEntity<Income> getIncomeByID(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(service.getIncome(id));
    }


    @GetMapping("all")
    public ResponseEntity<Page<IncomeDTO>> getAllIncomeByClientsAccount(@RequestParam(value = "size", required = false, defaultValue = "10") int page,
                                                                      @RequestParam(value = "page", required = false, defaultValue = "0") int size,
                                                                      @RequestBody DateDTO viewDTO) {
        return ResponseEntity.ok(service.getAllByClient(page, size, viewDTO));
    }
}
