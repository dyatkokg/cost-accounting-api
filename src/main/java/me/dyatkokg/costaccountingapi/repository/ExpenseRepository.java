package me.dyatkokg.costaccountingapi.repository;

import me.dyatkokg.costaccountingapi.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ExpenseRepository extends PagingAndSortingRepository<Expense, UUID> {

    Page<Expense> findWasteByAccount_ClientIdAndDateBetween(UUID uuid, Pageable pageable, LocalDate startDate, LocalDate endDate);

    List<Expense> findAllByCategory_NameAndDateBetween(String categoryName, LocalDate startDate, LocalDate endDate);
}
