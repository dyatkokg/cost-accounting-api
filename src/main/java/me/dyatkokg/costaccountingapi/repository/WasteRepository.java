package me.dyatkokg.costaccountingapi.repository;

import me.dyatkokg.costaccountingapi.entity.Waste;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface WasteRepository extends PagingAndSortingRepository<Waste, UUID> {
}
