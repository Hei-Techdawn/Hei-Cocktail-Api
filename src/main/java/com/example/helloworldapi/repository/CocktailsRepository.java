package com.example.helloworldapi.repository;

import com.example.helloworldapi.model.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocktailsRepository extends JpaRepository<Cocktail, Integer> {
}