package me.dyatkokg.costaccountingapi.repository;

import me.dyatkokg.costaccountingapi.entity.Waste;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.UUID;

public interface WasteRepository extends PagingAndSortingRepository<Waste, UUID> {

    Page<Waste> findWasteByAccount_ClientIdAndDateBetween(UUID uuid, Pageable pageable, LocalDate startDate, LocalDate endDate);
}
