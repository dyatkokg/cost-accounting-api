package me.dyatkokg.costaccountingapi.repository;

import me.dyatkokg.costaccountingapi.dto.AccountTransactionDTO;
import me.dyatkokg.costaccountingapi.entity.Income;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public interface IncomeRepository extends PagingAndSortingRepository<Income, UUID> {

    Page<Income> findIncomeByAccount_ClientIdAndDateBetween(UUID uuid, Pageable pageable, LocalDate startDate, LocalDate endDate);
    @Query(value = "select sum(amount_income)\n" +
            "from income i\n" +
            "join account a on i.account_id =a.id\n" +
            "where a.id = :id and  date between :startDate and :endDate",nativeQuery = true)
    BigDecimal getSumIncome(@Param("id") UUID uuid, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
