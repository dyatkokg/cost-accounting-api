package me.dyatkokg.costaccountingapi.service.impl;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.costaccountingapi.dto.CategoryDTO;
import me.dyatkokg.costaccountingapi.entity.Category;
import me.dyatkokg.costaccountingapi.mapper.CategoryMapper;
import me.dyatkokg.costaccountingapi.repository.CategoryRepository;
import me.dyatkokg.costaccountingapi.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    public Category addCategory(CategoryDTO category) {
        return repository.save(mapper.toEntity(category));
    }

    @Override
    public void deleteCategory(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }
}
