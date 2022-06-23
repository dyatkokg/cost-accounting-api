package me.dyatkokg.costaccountingapi.repository;

import me.dyatkokg.costaccountingapi.entity.IncomeCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface IncomeCategoryRepository extends CrudRepository<IncomeCategory, UUID> {

    IncomeCategory findCategoryByName(String name);

}
