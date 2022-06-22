package me.dyatkokg.costaccountingapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateDTO {

    private LocalDate startDate;

    private LocalDate endDate;
}
