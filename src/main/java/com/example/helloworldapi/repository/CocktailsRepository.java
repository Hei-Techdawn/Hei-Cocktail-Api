package com.example.helloworldapi.repository;

import com.example.helloworldapi.model.Cocktails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocktailsRepository extends JpaRepository<Cocktails, Integer> {
}
