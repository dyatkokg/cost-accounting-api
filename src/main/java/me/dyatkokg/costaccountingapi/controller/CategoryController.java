package me.dyatkokg.costaccountingapi.controller;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.costaccountingapi.dto.CategoryDTO;
import me.dyatkokg.costaccountingapi.entity.ExpenseCategory;
import me.dyatkokg.costaccountingapi.service.CategoryService;
import me.dyatkokg.costaccountingapi.utils.CategoryInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    public ResponseEntity<CategoryInterface> addCategory(@RequestBody CategoryDTO category) {
        return ResponseEntity.ok(service.addCategory(category));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ExpenseCategory> deleteCategory(@PathVariable("id") UUID id) {
        service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Object>> getAllCategoryByClient() {
        return ResponseEntity.ok(service.getAll());
    }
}
