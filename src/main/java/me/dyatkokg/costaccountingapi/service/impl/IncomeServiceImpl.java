package me.dyatkokg.costaccountingapi.service.impl;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.costaccountingapi.config.SecurityUtils;
import me.dyatkokg.costaccountingapi.dto.DateDTO;
import me.dyatkokg.costaccountingapi.dto.IncomeDTO;
import me.dyatkokg.costaccountingapi.entity.Account;
import me.dyatkokg.costaccountingapi.entity.Client;
import me.dyatkokg.costaccountingapi.entity.Income;
import me.dyatkokg.costaccountingapi.exception.IncomeNotFoundException;
import me.dyatkokg.costaccountingapi.mapper.AccountMapper;
import me.dyatkokg.costaccountingapi.mapper.IncomeMapper;
import me.dyatkokg.costaccountingapi.repository.IncomeRepository;
import me.dyatkokg.costaccountingapi.service.AccountService;
import me.dyatkokg.costaccountingapi.service.IncomeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository repository;

    private final IncomeMapper mapper;

    private final AccountService accountService;

    private final AccountMapper accountMapper;

    @Override
    public IncomeDTO addIncome(IncomeDTO incomeDTO) {
        Income income = mapper.toEntity(incomeDTO);
        income.setDate(LocalDate.now());
        Account account = accountService.getAccount(incomeDTO.getAccountId());
        account.setBalance(account.getBalance().add(income.getAmountIncome()));
        accountService.editAccount(account.getId(), accountMapper.toDTO(account));
        return mapper.toDTO(repository.save(income));
    }

    @Override
    public Income getIncome(UUID id) {
        return repository.findById(id).orElseThrow(IncomeNotFoundException::new);
    }

    @Override
    public Page<IncomeDTO> getAllByClient(int page, int size, DateDTO viewDTO) {
        Client principal = (Client) SecurityUtils.getPrincipal();
        Pageable pageable = PageRequest.of(size, page, Sort.Direction.DESC, "date");
        return repository.findIncomeByAccount_ClientIdAndDateBetween(principal.getId(), pageable,
                viewDTO.getStartDate(), viewDTO.getEndDate()).map(mapper::toDTO);
    }
}
