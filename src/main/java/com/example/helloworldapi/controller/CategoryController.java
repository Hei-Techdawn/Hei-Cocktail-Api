package com.example.helloworldapi.controller;

import com.example.helloworldapi.model.Category;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworldapi.service.TheCategoryService;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/category")
@CrossOrigin(origins = "*")
public class CategoryController {
    private TheCategoryService categoryService;

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
