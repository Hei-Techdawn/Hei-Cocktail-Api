package com.example.helloworldapi.service;

import com.example.helloworldapi.model.Category;
import com.example.helloworldapi.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Transactional
    public List<Category> createCategory(List<Category> categoryList) {
        return categoryRepository.saveAll(categoryList);
    }


    public Category updateCategory(int id, Category category) {
        Category oldCategory = categoryRepository.getReferenceById(id);
        if (category.getName() != null) {
            oldCategory.setName(category.getName());
        }
        if (category.getDescription() != null) {
            oldCategory.setDescription(category.getDescription());
        }
        return categoryRepository.save(oldCategory);
    }

    public Category getCategory(int id) {
        return categoryRepository.findById(id).get();
    }

    public void delete(int id) {
        categoryRepository.deleteById(id);
    }
}
