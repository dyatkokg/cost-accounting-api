package me.dyatkokg.costaccountingapi.service;

import me.dyatkokg.costaccountingapi.dto.CategoryDTO;
import me.dyatkokg.costaccountingapi.entity.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    Category addCategory(CategoryDTO category);

    void deleteCategory(UUID id);

    List<Category> getAll();
}
