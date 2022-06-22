package me.dyatkokg.costaccountingapi.repository;

import me.dyatkokg.costaccountingapi.entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends CrudRepository<Category, UUID> {

    List<Category> findAllByClientId(UUID uuid);

    Category findCategoryByName(String name);

    boolean existsCategoriesByName(String name);
}
