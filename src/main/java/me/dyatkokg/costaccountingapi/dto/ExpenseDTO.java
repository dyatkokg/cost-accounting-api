package me.dyatkokg.costaccountingapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {

    private UUID accountId;

    @NotNull(message = "Amount Spent should be presented")
    private BigDecimal amountSpent;

    private LocalDate date;

    @NotNull(message = "ExpenseCategory should be presented")
    private String category;
}
