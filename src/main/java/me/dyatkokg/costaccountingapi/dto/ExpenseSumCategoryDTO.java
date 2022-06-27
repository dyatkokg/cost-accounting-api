package me.dyatkokg.costaccountingapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseSumCategoryDTO {

    private String category;

    private BigDecimal sumExpense;

    private LocalDate startDate;

    private LocalDate endDate;


}
