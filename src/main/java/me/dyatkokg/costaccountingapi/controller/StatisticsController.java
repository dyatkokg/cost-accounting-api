package me.dyatkokg.costaccountingapi.controller;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.costaccountingapi.dto.DateDTO;
import me.dyatkokg.costaccountingapi.dto.StatisticClientDTO;
import me.dyatkokg.costaccountingapi.service.StatisticService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("statistic")
@RequiredArgsConstructor
public class StatisticsController {

private final StatisticService service;

    //todo:вывод полной статистики клиента за период с группировкой по дате(день, список транзакций, получено за день-списано за день),
    // отдельный контроллер? относится к клиенту

    @GetMapping
    public ResponseEntity<List<StatisticClientDTO>> getStatistic(@RequestBody DateDTO dateDTO){
        return ResponseEntity.ok(service.getStatisticByClient(dateDTO));
    }
}
