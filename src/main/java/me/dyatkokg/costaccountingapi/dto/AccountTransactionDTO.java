package me.dyatkokg.costaccountingapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountTransactionDTO {

    private UUID accountId;

    private BigDecimal totalIncome;

    private BigDecimal totalExpense;

}
