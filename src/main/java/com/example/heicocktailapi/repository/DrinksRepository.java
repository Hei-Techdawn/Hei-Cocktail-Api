package com.example.heicocktailapi.repository;

import com.example.heicocktailapi.model.Category;
import com.example.heicocktailapi.model.Drinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinksRepository extends JpaRepository<Drinks, Integer> {
    List<Drinks> getDrinksByCategory(Category category);
}
