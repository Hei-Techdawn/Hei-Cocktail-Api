package com.example.helloworldapi.service;

import com.example.helloworldapi.model.Category;
import com.example.helloworldapi.model.Drinks;
import com.example.helloworldapi.repository.CategoryRepository;
import com.example.helloworldapi.repository.DrinksRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DrinksService {
    private DrinksRepository drinksRepository;
    private CategoryRepository categoryRepository;

    public List<Drinks> findAllDrinks(int page, int size) {
        return drinksRepository.findAll(PageRequest.of(page, size)).toList();
    }

    public List<Drinks> createDrinks(List<Drinks> drinksList) {
        return drinksRepository.saveAll(drinksList);
    }

    public Drinks updateDrinks(int id, Drinks drinks) {
        Drinks oldDrinks = drinksRepository.getReferenceById(id);
        if (drinks.getName() != null) {
            oldDrinks.setName(drinks.getName());
        }
        if (drinks.getPrice() != 0) {
            oldDrinks.setPrice(drinks.getPrice());
        }
        if (drinks.getCategory() != null) {
            oldDrinks.setCategory(drinks.getCategory());
        }
        return drinksRepository.save(oldDrinks);
    }

    public void removeDrinks(int id) {
        drinksRepository.deleteById(id);
    }

    public Drinks findDrinks(int id) {
        return drinksRepository.findById(id).get();
    }

    public List<Drinks> findDrinksByIdCategory(int id) {
        return drinksRepository.getDrinksByCategory(
                categoryRepository.findById(id).get()
        );
    }
}
