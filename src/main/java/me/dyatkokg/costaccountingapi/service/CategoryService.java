package me.dyatkokg.costaccountingapi.service;

import me.dyatkokg.costaccountingapi.dto.CategoryDTO;
import me.dyatkokg.costaccountingapi.utils.CategoryInterface;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    CategoryInterface addCategory(CategoryDTO category);

    void deleteCategory(UUID id);

    List<Object> getAll();
}
