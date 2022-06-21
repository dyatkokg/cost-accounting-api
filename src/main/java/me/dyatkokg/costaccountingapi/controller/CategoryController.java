package me.dyatkokg.costaccountingapi.controller;

import lombok.RequiredArgsConstructor;
import me.dyatkokg.costaccountingapi.dto.CategoryDTO;
import me.dyatkokg.costaccountingapi.entity.Category;
import me.dyatkokg.costaccountingapi.service.CategoryService;
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
    public ResponseEntity<Category> addCategory(@RequestBody CategoryDTO category) {
        return ResponseEntity.ok(service.addCategory(category));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") UUID id) {
        service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Category>> getAllCategoryByClient(){
        return ResponseEntity.ok(service.getAll());
    }
}
