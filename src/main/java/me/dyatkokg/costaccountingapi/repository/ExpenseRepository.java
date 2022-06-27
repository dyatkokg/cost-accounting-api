package me.dyatkokg.costaccountingapi.repository;

import me.dyatkokg.costaccountingapi.dto.StatisticClientDTO;
import me.dyatkokg.costaccountingapi.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ExpenseRepository extends PagingAndSortingRepository<Expense, UUID> {

    Page<Expense> findWasteByAccount_ClientIdAndDateBetween(UUID uuid, Pageable pageable, LocalDate startDate, LocalDate endDate);

    List<Expense> findAllByCategory_NameAndDateBetween(String categoryName, LocalDate startDate, LocalDate endDate);

    @Query(value = "select sum(amount_spent)\n" +
            "from expense e\n" +
            " join account a on e.account_id =a.id\n" +
            " where a.id = :id and  date between :startDate and :endDate",nativeQuery = true)
    BigDecimal getSumExpense(@Param("id") UUID uuid, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value = "select sum(amount_spent)\n" +
            "from expense e\n" +
            " where date between :startDate and :endDate",nativeQuery = true)
    BigDecimal getTotalExpense(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


//    @Query(value = "select e.date, sum(amount_spent) as expensePerDay from expense e \n" +
//            "JOIN LATERAL EXTRACT(day FROM date) day ON TRUE \n" +
//            "WHERE e.date   >= '2022-06-21' AND e.date <= '2022-06-23'  \n" +
//            "GROUP BY e.date \n" +
//            "ORDER BY e.date ",nativeQuery = true)
//    List<StatisticClientDTO> getExpenseByDateBetween(LocalDate startDate, LocalDate endDate);
}
