package me.dyatkokg.costaccountingapi.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dyatkokg.costaccountingapi.config.SecurityUtils;
import me.dyatkokg.costaccountingapi.dto.DateDTO;
import me.dyatkokg.costaccountingapi.dto.StatisticClientDTO;
import me.dyatkokg.costaccountingapi.entity.Client;
import me.dyatkokg.costaccountingapi.repository.ClientRepository;
import me.dyatkokg.costaccountingapi.repository.ExpenseRepository;
import me.dyatkokg.costaccountingapi.repository.IncomeRepository;
import me.dyatkokg.costaccountingapi.service.StatisticService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class StatisticServiceImpl implements StatisticService {

    private final ClientRepository clientRepository;



    @Override
    public List<StatisticClientDTO> getStatisticByClient(DateDTO dateDTO) {
        Client principal = (Client) SecurityUtils.getPrincipal();
        return clientRepository.getStatisticByClient(principal.getId(),dateDTO.getStartDate(),dateDTO.getEndDate());

    }
}
