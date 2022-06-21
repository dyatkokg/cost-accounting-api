package me.dyatkokg.costaccountingapi.service.impl;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.costaccountingapi.config.SecurityUtils;
import me.dyatkokg.costaccountingapi.dto.WasteDTO;
import me.dyatkokg.costaccountingapi.dto.WasteDateDTO;
import me.dyatkokg.costaccountingapi.entity.Account;
import me.dyatkokg.costaccountingapi.entity.Client;
import me.dyatkokg.costaccountingapi.entity.Waste;
import me.dyatkokg.costaccountingapi.mapper.AccountMapper;
import me.dyatkokg.costaccountingapi.mapper.WasteMapper;
import me.dyatkokg.costaccountingapi.repository.AccountRepository;
import me.dyatkokg.costaccountingapi.repository.CategoryRepository;
import me.dyatkokg.costaccountingapi.repository.WasteRepository;
import me.dyatkokg.costaccountingapi.service.AccountService;
import me.dyatkokg.costaccountingapi.service.WasteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WasteServiceImpl implements WasteService {

    private final WasteRepository repository;

    private final WasteMapper mapper;

    private final AccountRepository accountRepository;

    private final AccountService accountService;

    private final AccountMapper accountMapper;

    private final CategoryRepository categoryRepository;

    @Override
    public WasteDTO addWaste(WasteDTO wasteDTO) {
        Waste waste = mapper.toEntity(wasteDTO);
        waste.setDate(LocalDate.now());
        waste.setCategory(categoryRepository.findCategoryByName(wasteDTO.getCategory()));
        Account account = accountRepository.findById(wasteDTO.getAccountId()).orElseThrow(RuntimeException::new);
        account.setBalance(account.getBalance().subtract(wasteDTO.getAmountSpent()));
        accountService.editAccount(account.getId(),accountMapper.toDTO(account));
        return mapper.toDTO(repository.save(waste));
    }

    @Override
    public Waste getWaste(UUID id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Page<WasteDTO> getAllByClient(int page, int size, WasteDateDTO viewDTO) {
        Client principal=(Client) SecurityUtils.getPrincipal();
        Pageable pageable = PageRequest.of(size, page);
        return repository.findWasteByAccount_ClientIdAndDateBetween(principal.getId(),pageable,
                viewDTO.getStartDate(),viewDTO.getEndDate()).map(mapper::toDTO);
    }

}
