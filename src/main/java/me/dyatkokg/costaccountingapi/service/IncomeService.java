package me.dyatkokg.costaccountingapi.service;

import me.dyatkokg.costaccountingapi.dto.DateDTO;
import me.dyatkokg.costaccountingapi.dto.IncomeDTO;
import me.dyatkokg.costaccountingapi.entity.Income;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface IncomeService {
    IncomeDTO addIncome(IncomeDTO incomeDTO);

    Income getIncome(UUID id);

    Page<IncomeDTO> getAllByClient(int page, int size, DateDTO viewDTO);
}
