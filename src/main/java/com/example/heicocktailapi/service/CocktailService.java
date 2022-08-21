package com.example.heicocktailapi.service;

import com.example.heicocktailapi.model.Cocktail;
import com.example.heicocktailapi.model.Drinks;
import com.example.heicocktailapi.repository.CocktailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class CocktailService {
    private CocktailsRepository cocktailsRepository;

    public List<Cocktail> getAllCocktails(int page, int size) {
        List<Cocktail> cocktailsList = cocktailsRepository.findAll(PageRequest.of(page, size)).toList();
        for (Cocktail cocktails : cocktailsList) {
            cocktails.setPrice(sumPriceDrinks(cocktails.getDrinks()));
        }
        return cocktailsList;
    }

    public double sumPriceDrinks(List<Drinks> drinksList) {
        double sum = 0;
        for (Drinks drinks : drinksList) {
            sum += drinks.getPrice();
        }
        return sum;
    }

    @Transactional
    public List<Cocktail> createCocktails(List<Cocktail> cocktailsList) {
        return cocktailsRepository.saveAll(cocktailsList);
    }

    public Cocktail findCocktail(int id) {
        Cocktail cocktail = cocktailsRepository.findById(id).get();
        cocktail.setPrice(sumPriceDrinks(cocktail.getDrinks()));
        return cocktail;
    }

    public void deleteCocktailById(int id) {
        cocktailsRepository.deleteById(id);
    }

    public Cocktail updateCocktail(int id, Cocktail cocktail) {
        Cocktail oldCocktail = cocktailsRepository.findById(id).get();
        if (cocktail.getName() != null) {
            oldCocktail.setName(cocktail.getName());
        }
        if (cocktail.getDescription() != null) {
            oldCocktail.setDescription(cocktail.getDescription());
        }
        if (cocktail.getDrinks() != null) {
            oldCocktail.setDrinks(cocktail.getDrinks());
        }
        return cocktailsRepository.save(oldCocktail);
    }
}
