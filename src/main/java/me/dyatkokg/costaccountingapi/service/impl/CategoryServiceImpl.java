package me.dyatkokg.costaccountingapi.service.impl;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.costaccountingapi.config.SecurityUtils;
import me.dyatkokg.costaccountingapi.dto.CategoryDTO;
import me.dyatkokg.costaccountingapi.entity.Category;
import me.dyatkokg.costaccountingapi.entity.Client;
import me.dyatkokg.costaccountingapi.exception.CategoryAlreadyExistException;
import me.dyatkokg.costaccountingapi.mapper.CategoryMapper;
import me.dyatkokg.costaccountingapi.repository.CategoryRepository;
import me.dyatkokg.costaccountingapi.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @Override
    public Category addCategory(CategoryDTO category) {
        if (repository.existsCategoriesByName(category.getName())) {
            throw new CategoryAlreadyExistException();
        }
        category.setClient((Client) SecurityUtils.getPrincipal());
        return repository.save(mapper.toEntity(category));
    }

    @Override
    public void deleteCategory(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<Category> getAll() {
        Client principal = (Client) SecurityUtils.getPrincipal();
        return repository.findAllByClientId(principal.getId());
    }
}
