package me.dyatkokg.costaccountingapi.repository;

import me.dyatkokg.costaccountingapi.entity.Income;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface IncomeRepository extends PagingAndSortingRepository<Income, UUID> {
}
