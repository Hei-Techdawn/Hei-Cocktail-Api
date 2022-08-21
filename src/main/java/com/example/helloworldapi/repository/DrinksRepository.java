package com.example.helloworldapi.repository;

import com.example.helloworldapi.model.Category;
import com.example.helloworldapi.model.Drinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinksRepository extends JpaRepository<Drinks, Integer> {
    List<Drinks> getDrinksByCategory(Category category);
}
