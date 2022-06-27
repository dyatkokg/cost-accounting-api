package me.dyatkokg.costaccountingapi.service;

import me.dyatkokg.costaccountingapi.dto.DateDTO;
import me.dyatkokg.costaccountingapi.dto.StatisticClientDTO;

import java.util.List;

public interface StatisticService {
    List<StatisticClientDTO> getStatisticByClient(DateDTO dateDTO);
}
