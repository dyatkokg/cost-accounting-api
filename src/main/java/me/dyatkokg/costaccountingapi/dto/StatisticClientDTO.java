package me.dyatkokg.costaccountingapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public interface StatisticClientDTO {

//    private String clientId;
//
//    private String date;
//
//    private String amount;

//    LocalDate getDate();
//
//    BigDecimal getIncomePerDay();
//
//    BigDecimal getExpensePerDay();

    UUID getClient();
    LocalDate getDate();
    BigDecimal getAmount();


}
