package com.example.heicocktailapi.controller;

import com.example.heicocktailapi.model.Category;
import com.example.heicocktailapi.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/category")
@CrossOrigin(origins = "*")
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping(value = "")
    public List<Category> getAllCategory() {
        return categoryService.findAllCategory();
    }

    @PostMapping(value = "")
    public List<Category> postCategory(
            @RequestBody List<Category> categoryList
    ) {
        return categoryService.createCategory(categoryList);
    }

    @PutMapping(value = "/{id}")
    public Category putCategory(
            @PathVariable int id,
            @RequestBody Category category
    ) {
        category.setId(id);
        return categoryService.updateCategory(id, category);
    }

    @GetMapping(value = "/{id}")
    public Category getCategory(
            @PathVariable int id
    ) {
        return categoryService.getCategory(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCategory(
            @PathVariable int id
    ) {
        categoryService.delete(id);
    }
}
