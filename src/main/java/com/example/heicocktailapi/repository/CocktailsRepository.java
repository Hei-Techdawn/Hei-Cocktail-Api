package com.example.heicocktailapi.repository;

import com.example.heicocktailapi.model.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocktailsRepository extends JpaRepository<Cocktail, Integer> {
}
