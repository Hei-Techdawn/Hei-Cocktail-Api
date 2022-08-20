package com.example.helloworldapi.repository;

import com.example.helloworldapi.model.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocktailsRepository extends JpaRepository<Cocktail, Integer> {
}
