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
public class IncomeDTO {

    private UUID accountId;

    @NotNull(message = "Amount income should be presented")
    private BigDecimal amountIncome;

    private LocalDate date;
}
