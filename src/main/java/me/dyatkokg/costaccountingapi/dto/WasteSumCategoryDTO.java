package me.dyatkokg.costaccountingapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WasteSumCategoryDTO {

    private String category;

    private BigDecimal sumWaste;

    private LocalDate startDate;

    private LocalDate endDate;


}
