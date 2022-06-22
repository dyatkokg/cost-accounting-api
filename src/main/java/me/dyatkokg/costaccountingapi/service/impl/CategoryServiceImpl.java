package me.dyatkokg.costaccountingapi.service.impl;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.costaccountingapi.config.SecurityUtils;
import me.dyatkokg.costaccountingapi.dto.CategoryDTO;
import me.dyatkokg.costaccountingapi.entity.Client;
import me.dyatkokg.costaccountingapi.mapper.CategoryMapper;
import me.dyatkokg.costaccountingapi.repository.ExpenseCategoryRepository;
import me.dyatkokg.costaccountingapi.repository.IncomeCategoryRepository;
import me.dyatkokg.costaccountingapi.service.CategoryService;
import me.dyatkokg.costaccountingapi.utils.CategoryInterface;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final ExpenseCategoryRepository expenseRepository;

    private final IncomeCategoryRepository incomeRepository;

    private final CategoryMapper mapper;

    @Override
    public CategoryInterface addCategory(CategoryDTO category) {
        category.setClient((Client) SecurityUtils.getPrincipal());
        if (category.getType().equals("expense")) {
            return expenseRepository.save(mapper.toExpenseEntity(category));
        } else if (category.getType().equals("income")) {
            return incomeRepository.save(mapper.toIncomeEntity(category));
        } else throw new RuntimeException();
    }



    @Override
    public void deleteCategory(UUID id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public List<Object> getAll() {
        Client principal = (Client) SecurityUtils.getPrincipal();
        return Collections.singletonList(expenseRepository.findAllByClientId(principal.getId()));
    }
}
