package me.dyatkokg.costaccountingapi.repository;

import me.dyatkokg.costaccountingapi.entity.ExpenseCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ExpenseCategoryRepository extends CrudRepository<ExpenseCategory, UUID> {

    List<ExpenseCategory> findAllByClientId(UUID uuid);

    ExpenseCategory findCategoryByName(String name);

    boolean existsCategoriesByName(String name);
}
