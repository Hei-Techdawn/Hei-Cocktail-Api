package com.example.helloworldapi.repository;

import com.example.helloworldapi.model.Drinks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinksRepository extends JpaRepository<Drinks, Integer> {
}
