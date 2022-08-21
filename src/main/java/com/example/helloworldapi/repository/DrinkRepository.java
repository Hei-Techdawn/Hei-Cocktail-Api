package com.example.helloworldapi.repository;

import com.example.helloworldapi.model.Category;
import com.example.helloworldapi.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Integer> {
    List<Drink> getDrinksByCategory(Category category);
}
